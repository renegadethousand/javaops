package com.startjava.lesson_2_3_4.array;

import java.util.Scanner;

public class ArrayMaxElementMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите длину массив: ");
        int maxLength = scanner.nextInt();
        int[] numbers = new int[maxLength];

        System.out.print("Заполните массив целыми числами через пробел: ");

        for (int i = 0; i < maxLength; i++) {
            numbers[i] = scanner.nextInt();
        }

        int maxElement = numbers[0];

        for (int i = 0; i < maxLength; i++) {
            if (maxElement < numbers[i]) {
                maxElement = numbers[i];
            }
        }

        System.out.println("Максимальное число = " + maxElement);
    }
}
