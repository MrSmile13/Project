package socket2;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.nio.charset.Charset;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class Server2 {
    public static void main(String[] args) throws IOException{

        ServerSocket ss = new ServerSocket(3333);

        ExecutorService p = Executors.newCachedThreadPool();

        AtomicInteger count = new AtomicInteger();

        while (true) {

            Socket sc = ss.accept();

            p.submit( () -> {
                        try {
                            System.out.printf("Установлено соединение №%d с клиентом %s.\n",
                                    count.incrementAndGet(), sc.getInetAddress().toString());

                            BufferedReader reader = new BufferedReader(new InputStreamReader(sc.getInputStream(),
                                    Charset.forName("UTF-8")));

                            String s = reader.readLine();

                            System.out.printf("Строка от клиента: %s\n", s);

                            String out = s.toUpperCase();

                            System.out.printf("Отданная строка: %s\n", out);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(sc.getOutputStream(),
                                    Charset.forName("UTF-8")));

                            writer.write(out + " . Server: " +
                                    Thread.currentThread().getName() + "\n");
                            writer.flush();

                            if (s.contains("stop")) {
                                System.out.printf("Сервер остановлен.");
                                p.shutdown();
                                ss.close();
                                writer.close();
                                sc.close();

                            }
                        }
                        catch (IOException e){
                            e.printStackTrace();
                        }
                    }
            );
        }

    }
}
