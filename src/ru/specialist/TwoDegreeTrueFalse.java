package ru.specialist;

import java.util.Scanner;

public class TwoDegreeTrueFalse {

    public static void main(String[] args) {

        Scanner stage = new Scanner(System.in);

        System.out.println("\nДанная программа проверяет, является ли число степенью двойки.");

        System.out.print("Введите число: ");
        int x = stage.nextInt();

        boolean b = ((x != 0) && (x & (x - 1)) == 0);

        System.out.println(b);

        System.out.print("Благодарим за внимание!\n");

    }

}
