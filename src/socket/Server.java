package socket;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;

import static java.lang.System.out;


public class Server {

    /**
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {

        // 127.0.0.1:1111


        ServerSocket ss = new ServerSocket(2222);
        int req = 0;

        while (true)
        {
            Socket cs = ss.accept();

            out.printf("Accept connection from %s\n",
                    cs.getInetAddress().toString());

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(cs.getInputStream(),
                            Charset.forName("UTF-8")));

//            String s = reader.readLine();

            String phoneNumber = reader.readLine();

            out.printf("%s . %d\n", phoneNumber, ++req);
            Thread.sleep(100);

            OutputStreamWriter writer = new OutputStreamWriter(
                    cs.getOutputStream(),
                    Charset.forName("UTF-8"));

//            writer.write(s.toUpperCase()+ "\n");
//            writer.write(". req = " + req + "\n");
//            writer.flush();

            String regularExpression = "[^0-9]";

            String number = phoneNumber.replaceAll(regularExpression, "");

            int goodNumber = 11;

            writer.write("Server message...\n");
            writer.write("Введенный Вами номер: " + phoneNumber + "\n");
            writer.write("Откорректированный номер: " + number + "\n");

            if (number.length() == goodNumber) {
                writer.write("Вы ввели корректный номер.\n");
            }
            else {
                writer.write("Введенный номер некорректен.\n");
            }

            writer.write("cs.LocalSocketAddress:" + cs.getLocalSocketAddress() + "\n");

            writer.write("req = " + req + "\n");
            writer.write("End server message.\n");

            writer.flush();

            if (phoneNumber.equals("stop"))
            {
                out.println("Сервер остановлен");
                ss.close();
                writer.close();
                cs.close();
                break;
            }


        }

    }

}
