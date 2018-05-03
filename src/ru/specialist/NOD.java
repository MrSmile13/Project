package ru.specialist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NOD {
    public static void main(String[] args) {

        Scanner numScan = new Scanner(System.in);

        ArrayList<Integer> nums = new ArrayList<Integer>();

        String a;
        int y, z = 1;

        System.out.println("Добро пожаловать в программу подсчета НОД!");

        while (true) {
            System.out.printf("Введите число %d: ", z);
            a = numScan.nextLine().trim();
            metka:
            if (a.isEmpty()) {
                if (nums.size() == 1) {
                    System.out.println("Вы ввели одно число. Для подсчета НОД необходимо ввести более двух чисел.");
                    break metka;
                } else break;
            } else {
                y = Integer.parseInt(a);
                nums.add(y);
                z++;
            }
        }

        String numStr = String.valueOf(nums);

        int numNOD = gcd(nums);

        System.out.printf("\nНОД для чисел %s равен: %d", numStr.substring(1, numStr.length() - 1), numNOD);

    }


    public static int gcd(ArrayList<Integer> numsList) {

        Collections.sort(numsList);
        Collections.reverse(numsList);

        int res = Math.abs(numsList.get(0));

        for (int num : numsList) {
            if (num == numsList.get(numsList.size() - 1)) break;

            int num2 = Math.abs(numsList.get(numsList.indexOf(num) + 1));

            while (num2 != 0) {
                int m = res % num2;
                res = num2;
                num2 = m;
            }

        }
        return res;
    }
}
