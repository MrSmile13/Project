package ru.specialist;

import java.util.Scanner;

public class NodForTwo {
    public static void main(String[] args) {
        Scanner numScan = new Scanner(System.in);
        int a, b;

        System.out.println("Добро пожаловать в программу подсчета НОД!");

        System.out.print("Введите число \"a\": ");
        a = numScan.nextInt();

//        while (a == 0) {
//            System.out.print("Число \"а\" не может быть равно 0. Введите любое натуральное число: ");
//            a = numScan.nextInt();
//        }

        System.out.print("Введите число \"b\": ");
        b = numScan.nextInt();

//        while (b == 0) {
//            System.out.print("Число \"b\" не может быть равно 0. Введите любое натуральное число: ");
//            b = numScan.nextInt();
//        }

//        NodForTwo gcdAlgoritm = new NodForTwo();
//        int numSum = gcdAlgoritm.gcd(a, b);

        int numNOD = gcd(Math.abs(a), Math.abs(b));

        System.out.printf("\nНаибольший общий делитель для чисел %d и %d равен: %d", a, b, numNOD);
    }


    //    public int gcd(int num1, int num2){
    public static int gcd(int num1, int num2) {
        while (num1 != 0 && num2 != 0) {
            if (num1 > num2)
                num1 %= num2;
            else num2 %= num1;
        }
        return (num1 + num2);
    }

}
