package ru.specialist;

import java.util.Scanner;

public class DegreeTwo {

    public static void main(String[] args) {

        Scanner stage = new Scanner(System.in);

        System.out.println("\nДанная программа проверяет, является ли число степенью двойки.");

        int y;

        do {
            System.out.print("Введите число: ");
            int x = stage.nextInt();

            boolean b;

            if (x == 0) {
                b = false;
                System.out.printf("\nРезультат: %b", b);
                System.out.printf("\n%12d не является степенью двойки.\n", x);
            } else if ((x & (x - 1)) == 0) {
                b = true;
                System.out.printf("\nРезультат: %b", b);
                System.out.printf("\n\t\t   %d является степенью двойки.\n", x);
            } else {
                b = false;
                System.out.printf("\nРезультат: %b", b);
                System.out.printf("\n\t\t   %d не является степенью двойки.\n", x);
            }
            System.out.println("\nДля проверки другого числа нажмите - 1, для выхода нажмите любую цифру.");
            y = stage.nextInt();
        } while (y == 1);

        System.out.print("Благодарим за внимание!\n");

    }

}
