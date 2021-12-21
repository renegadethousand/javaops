package com.startjava.lesson_1.game;

import java.util.*;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int randomNumber = 50;
        while (true) {
            System.out.println("Введите загаданное число"); 
            int playerNumber = input.nextInt();

            if (playerNumber == randomNumber) {
                System.out.println("Поздравляю, число угадано!");
                break;
            } else if (playerNumber > randomNumber) {
                System.out.println("Данное число больше того, что загадал компьютер");
            } else {
                System.out.println("Данное число меньше того, что загадал компьютер");
            }
        }
    }
}