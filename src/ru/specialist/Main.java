package ru.specialist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Добро пожаловать в программу решения квадратного уравнения!\n");
        System.out.print("Квадратное уравнение - это уравнение вида - ax^2 + bx + c = 0,\n");
        System.out.println("где коэффициенты a, b и c — произвольные числа, причем a ≠ 0.\n");
        System.out.println("Введите коэффициенты a, b и c.");
        String a, b, c;

        System.out.print("\tВведите \"a\": ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        a = reader.readLine();

        double aa = Double.parseDouble(a);

        while (aa == 0) {
            System.out.println("\nКоэффициент \"а\" не может быть равным 0.");
            System.out.print("\tВведите коэффициент \"a\" повторно: ");
            a = reader.readLine();
            aa = Double.parseDouble(a);
        }

        //if (aa == 0) System.out.println("Коэффициент \"а\" не может быть равным 0.");
        //else {

        System.out.print("\tВведите \"b\": ");
        b = reader.readLine();

        System.out.print("\tВведите \"c\": ");
        c = reader.readLine();

        double bb = Double.parseDouble(b);
        double cc = Double.parseDouble(c);

        //Вычисляем дискриминант D = b^2 − 4ac
        double D = Math.pow(bb, 2) - (4 * aa * cc);

        System.out.println("\nВычисляем дискриминант...");
        System.out.printf("\t\tD = %.2f", D);

        if (D < 0) System.out.println("\nДискриминант < 0. Нет действительных корней.");
        else if (D == 0) {
            System.out.printf(" ⇒ уравнение имеет один корень.\n\n");
            double x, answ;

            x = (-bb + Math.sqrt(D)) / (2 * aa);

            System.out.printf("Корень уравнения x = %f\n\n", x);

            answ = (aa * Math.pow(x, 2)) + (bb * x) + cc;
            System.out.println("Проверка произведенных расчетов!");
            System.out.printf("\tВаше уравнение: %.2f * %.2f^2 + %.2f * %.2f + %.2f = 0\n", aa, x, bb, x, cc);
            System.out.printf("\tЛевая часть уравнения равна: %.2f\n", answ);

        } else {
            System.out.printf(" ⇒ уравнение имеет два корня.\n\n");
            double x1, x2, answ1, answ2;

            x1 = (-bb + Math.sqrt(D)) / (2 * aa);
            x2 = (-bb - Math.sqrt(D)) / (2 * aa);

            System.out.printf("Первый корень: x1 = %f\nВторой корень: x2 = %f\n\n", x1, x2);

            answ1 = (aa * Math.pow(x1, 2)) + (bb * x1) + cc;
            answ2 = (aa * Math.pow(x2, 2)) + (bb * x2) + cc;

            System.out.println("Проверка произведенных расчетов!");
            System.out.printf("\tВаше уравнение с x1: %.2f * %.2f^2 + %.2f * %.2f + %.2f = 0\n", aa, x1, bb, x1, cc);
            System.out.printf("\tЛевая часть уравнения для первого корня равна: %.2f\n\n", answ1);
            System.out.printf("\tВаше уравнение с x2: %.2f * %.2f^2 + %.2f * %.2f + %.2f = 0\n", aa, x2, bb, x2, cc);
            System.out.printf("\tЛевая часть уравнения для второго корня равна: %.2f\n", answ1);


        }


        //}
    }
}
