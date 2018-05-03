package string;

import java.util.Scanner;
import java.util.Date;

public class DifferentString {
    public static void main(String[] args) {
        int dlina = 500000000;
        System.out.printf("Заполняем строку %d символов \"a\" в трёх вариантах:\n\t1) в качестве строки используется структура String;",dlina);
        System.out.println("\n\t2) в качестве строки используется структура StringBuffer;\n\t2) в качестве строки используется структура StringBuilder.\n");
        String str = "";
        Date date = new Date();
        Date date1 = new Date();

        date = new Date();
        System.out.print("Вариант 1. \n\tВремя до начала заполнения (мс): ");
        System.out.println(date.getTime());
        for (int i = 0; i <=dlina; i++)
            str += "a";
        date1 = new Date();
        System.out.print("\tВремя после окончания заполнения (мс): ");
        System.out.println(date1.getTime());
        System.out.print("\tРазница времени заполнения (мс): ");
        System.out.println(date1.getTime() - date.getTime());

        StringBuffer strBuffer = new StringBuffer("");
        date = new Date();
        System.out.print("Вариант 2. \n\tВремя до начала заполнения (мс): ");
        System.out.println(date.getTime());
        for (int i = 0; i <=dlina; i++)
            strBuffer.append("a");
        date1 = new Date();
        System.out.print("\tВремя после окончания заполнения (мс): ");
        System.out.println(date1.getTime());
        System.out.print("\tРазница времени заполнения (мс): ");
        System.out.println(date1.getTime() - date.getTime());
        System.out.println("\tЕмкость: " + strBuffer.capacity());
        System.out.println("\tДлина строки: " + strBuffer.length());

        StringBuilder strBuilder = new StringBuilder("");
        date = new Date();
        System.out.print("Вариант 3. \n\tВремя до начала заполнения (мс): ");
        System.out.println(date.getTime());
        for (int i = 0; i <=dlina; i++)
            strBuilder.append("a");
        date1 = new Date();
        System.out.print("\tВремя после окончания заполнения (мс): ");
        System.out.println(date1.getTime());
        System.out.print("\tРазница времени заполнения (мс): ");
        System.out.println(date1.getTime() - date.getTime());
        System.out.println("\tЕмкость: " + strBuilder.capacity());
        System.out.println("\tДлина строки: " + strBuilder.length());


    }
}
