package different;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Counter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите число: ");
        String[] str = reader.readLine().trim().replace(" ", "").split("");
        int x = 0;
        for (int i = 0; i < str.length; i++)
            x += Integer.valueOf(str[i]);

        System.out.printf("Результат: %d\n", x);
    }
}
