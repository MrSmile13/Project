package sin;

class Sync{
    private static double x = Math.toRadians(90);
    static boolean phase = true;

    public static void setX(double z){
        x = z;
    }

    public static double getX(){
        return x;
    }
}

public class SinThread {
    public static void main(String[] args){

        Sync sinm = new Sync();

        System.out.println("t0 - sin, t1 - asin\n");
        System.out.printf("В радианах x = %f\n\n", Sync.getX());
        System.out.printf("В градусах x = %f\n\n", Math.toDegrees(Sync.getX()));

        Thread t0 = new Thread( () -> {
            for (int i = 1; i <= 10; i++) {

                while (Sync.phase == false) {
                    try {
                        synchronized(sinm) {
                            sinm.wait();
                        }}
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Sync.setX(Math.sin(Sync.getX()));
                System.out.printf("%s: i = %d, x = %f\n", Thread.currentThread().getName(), i, Sync.getX());
                Sync.phase = false;

                synchronized (sinm) {
                    sinm.notify();
                }

            }
        });

        Thread t1 = new Thread( () -> {
            for (int i = 1; i <= 10; i++) {

                while (Sync.phase == true) {
                    try {
                        synchronized(sinm) {
                            sinm.wait();
                        }}
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Sync.setX(Math.asin(Sync.getX()));
                System.out.printf("\t%s: i = %d, x = %f\n", Thread.currentThread().getName(), i, Math.toDegrees(Sync.getX()));
                Sync.phase = true;

                synchronized (sinm) {
                    sinm.notify();
                }
            }
        });

        t0.start();
        t1.start();

        try {
            t0.join();
            t1.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("\n%s: в радианах x = %.2f\n", Thread.currentThread().getName(), Sync.getX());

    }
}

