package socket;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;


import static java.lang.System.out;


public class Client {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Socket cs = new Socket("localhost", 2222);

        OutputStreamWriter writer =
                new OutputStreamWriter(cs.getOutputStream(),
                        Charset.forName("UTF-8"));

        writer.write("8(915)123-45-67\n");
        writer.flush();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(cs.getInputStream(),
                        Charset.forName("UTF-8")));

//        int c;
//
//        while ( (c = reader.read()) != -1) {
//            out.print((char)c);
//        }

        String s;

        while ( (s = reader.readLine()) != null) {
            out.println(s);
        }

        out.println("Сообщение клиента: " + cs.getInetAddress());

    }

}


