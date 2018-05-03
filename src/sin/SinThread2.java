package sin;

public class SinThread2 {
    public static void main(String[] args){

        class SinM{
            private double x = Math.toRadians(90);

            boolean phase = true;

            public void setX(double z){
                x = z;
            }

            public double getX(){
                return x;
            }

        }

        SinM msin = new SinM();

        System.out.println("t0 - sin, t1 - asin");
        System.out.printf("В радианах x = %f\n", msin.getX());
        System.out.printf("В градусах x = %f\n\n", Math.toDegrees(msin.getX()));

        Thread t0 = new Thread( () -> {
            for (int i = 1; i <= 10; i++) {

                while (msin.phase == false) {
                    try {
                        synchronized(msin) {
                            msin.wait();
                        }}
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                msin.setX(Math.sin(msin.getX()));
                System.out.printf("%s: i = %d, x = %f\n", Thread.currentThread().getName(), i, msin.getX());
                msin.phase = false;

                synchronized (msin) {
                    msin.notify();
                }

            }
        });

        Thread t1 = new Thread( () -> {
            for (int i = 1; i <= 10; i++) {

                while (msin.phase == true) {
                    try {
                        synchronized(msin) {
                            msin.wait();
                        }}
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                msin.setX(Math.asin(msin.getX()));
                System.out.printf("\t%s: i = %d, x = %f\n", Thread.currentThread().getName(), i, Math.toDegrees(msin.getX()));
                msin.phase = true;

                synchronized (msin) {
                    msin.notify();
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

        System.out.printf("\n%s: в радианах x = %.2f\n", Thread.currentThread().getName(), msin.getX());

    }
}
