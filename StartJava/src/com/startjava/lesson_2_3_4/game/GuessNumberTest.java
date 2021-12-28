package com.startjava.lesson_2_3_4.game;

import java.util.Scanner;

public class GuessNumberTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choicesAmount = 3;
        int maxGames = 3;
        Player[] players = createPlayers(choicesAmount, scanner);

        GuessNumber game = new GuessNumber(players, maxGames);
        String answer = "yes";

        do {
            if (answer.equals("yes")) {
                game.start();
            }

            System.out.println("Хотите продолжить игру? [yes/no]:");
            answer = scanner.nextLine();
        } while (!answer.equals("no"));
    }

    private static Player[] createPlayers(int choicesAmount, Scanner scanner) {
        Player[] players = new Player[3];

        for (int i = 0; i < players.length; i++) {
            System.out.println("Введите имя игрока " + (i + 1));
            String playerName = scanner.nextLine();
            players[i] = new Player(playerName, choicesAmount);
        }
        return players;
    }
}