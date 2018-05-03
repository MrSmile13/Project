package socket2;

import java.net.Socket;
import java.io.*;
import java.nio.charset.Charset;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class Client2 {

    public static final int CONNECTIONS = 100;

    public static void main(String[] args) throws IOException {

        ExecutorService p = Executors.newFixedThreadPool(CONNECTIONS);

        Runnable task = () -> {
            try {
                Socket sc = new Socket("localhost", 3333);

                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(sc.getOutputStream(),
                        Charset.forName("UTF-8")));

                writer.write("test\n");
                writer.flush();

                BufferedReader reader = new BufferedReader(new InputStreamReader(sc.getInputStream(),
                        Charset.forName("UTF-8")));

                System.out.println(reader.readLine() + " . Client: " + Thread.currentThread().getName());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        };

        for(int i = 0; i < CONNECTIONS; i++){
            p.submit(task);
        }
        p.shutdown();
    }
}
