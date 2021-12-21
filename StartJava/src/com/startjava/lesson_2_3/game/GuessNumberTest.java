package com.startjava.lesson_2_3.game;

import java.util.Scanner;

public class GuessNumberTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Введиите имя игрока 1");
        String playerOneName = input.nextLine();
        Player playerOne = new Player(playerOneName);

        System.out.println("Введиите имя игрока 2");
        String playerTwoName = input.nextLine();
        Player playerTwo = new Player(playerTwoName);

        GuessNumber game = new GuessNumber(playerOne, playerTwo);

        String answer = "yes";

        do {
            if (answer.equals("yes")) {
                game.start();
            }

            System.out.println("Хотите продолжить игру? [yes/no]:");
            answer = input.nextLine();
        } while (!answer.equals("no"));
    }
}