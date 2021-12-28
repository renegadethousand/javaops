package com.startjava.lesson_2_3_4.game;

import java.util.Scanner;

public class GuessNumberTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int choicesAmount = 3;
        int maxGames = 3;
        int playersCount = 3;
        Player[] players = initPlayers(playersCount, choicesAmount);

        GuessNumber game = new GuessNumber(players, maxGames);
        String answer = "yes";

        do {
            if (answer.equals("yes")) {
                game.start();
            }

            System.out.println("Хотите продолжить игру? [yes/no]:");
            answer = input.nextLine();
        } while (!answer.equals("no"));
    }

    private static Player[] initPlayers(int playersCount, int choicesAmount) {
        Scanner input = new Scanner(System.in);
        Player[] players = new Player[playersCount];

        for (int i = 0; i < players.length; i++) {
            System.out.println("Введите имя игрока " + (i + 1));
            String playerName = input.nextLine();
            Player player = new Player(playerName, choicesAmount);
            players[i] = player;
        }
        return players;
    }
}