package different;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Guess {
    public static void main(String[] args)throws IOException{

        char a = 'H';
        char x;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print("Enter letter from A to Z: ");
            x = reader.readLine().trim().toUpperCase().charAt(0);

            if (x == a) System.out.println("Right");
            else if (x < a) System.out.println("You're too low");
            else System.out.println("You're too high");
        } while (x != a);
    }
}
