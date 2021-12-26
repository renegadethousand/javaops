package com.startjava.lesson_2_3_4.game;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessNumberTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int choicesAmount = 3;
        int gamesCount = 0;
        int maxGames = 3;
        int playersCount = 3;
        Player[] players = new Player[playersCount];
        int firstPosition = random.nextInt(playersCount);

        for (int i = 0; i < players.length; i++) {
            System.out.println("Введите имя игрока " + (i + 1));
            String playerName = input.nextLine();
            Player player = new Player(playerName, choicesAmount);
            players[i] = player;
        }

        System.out.println("Бросаем жребий...");

        System.out.println("Первым ходит: " +  players[firstPosition].getName());

        if (firstPosition > 0) {
            Player switchedPlayer = players[0];
            players[0] = players[firstPosition];
            players[firstPosition] = switchedPlayer;
        }

        System.out.println("Порядок угадывания следующий:");
        for (Player player: players) {
            System.out.println(player.getName());
        }

        System.out.println("У каждого игрока по " + choicesAmount + " попыток");

        GuessNumber game = new GuessNumber(players);

        String answer = "yes";

        do {
            gamesCount++;
            if (answer.equals("yes")) {
                fillPlayers(players);
                game.start();
            }

            if (gamesCount == maxGames) {
                findWinner(players);
                System.out.println("Хотите продолжить игру? [yes/no]:");
                answer = input.nextLine();
                gamesCount = 0;
            }

        } while (!answer.equals("no"));
    }

    private static void findWinner(Player[] players) {
        int[] numbers = new int[players.length];
        for (int i = 0; i < players.length; i++) {
            numbers[i] = players[i].getWinsCount();
        }

        Arrays.sort(numbers);

        int maxNumber = numbers[numbers.length-1];

        if (maxNumber == 0 || numbers.length > 1 && maxNumber == numbers[numbers.length-2]) {
            System.out.println("Победителя выявить неудалось");
        } else {
            for (Player player : players) {
                if (maxNumber == player.getWinsCount()) {
                    System.out.println("Победител игрок: " + player.getName());
                }
            }
        }

        System.out.println("Статистика");
        for (Player player : players) {
            System.out.println("Игрок: " + player.getName() + ", количество побед: " + player.getWinsCount());
        }
    }

    private static void fillPlayers(Player[] players) {
        for (Player player : players) {
            player.fill();
        }
    }
}