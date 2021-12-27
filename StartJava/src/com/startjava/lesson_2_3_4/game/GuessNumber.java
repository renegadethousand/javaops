package com.startjava.lesson_2_3_4.game;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class GuessNumber {

    private Player[] players;
    private int gamesCount;

    public GuessNumber(Player[] players) {
        this.players = players;
    }

    public void shufflePlayers() {
        Random random = new Random();
        int firstPosition = random.nextInt(players.length);
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
    }

    public void start() {
        Random random = new Random();
        int randomNumber = random.nextInt(101);
        gamesCount++;

        shufflePlayers();

        System.out.println("Загадано число: " + randomNumber);

        do {
            boolean gameWin = false;
            boolean endGame = true;

            for (Player currentPlayer : players) {
                if (currentPlayer.getAvailableChoice() > 0) {
                    if (numberGuessed(randomNumber, currentPlayer)) {
                        System.out.println("Числа игрока " + currentPlayer.getName() + ": " + Arrays.toString(Arrays.copyOf(currentPlayer.getNumbers(), currentPlayer.getChoiceCount())));
                        currentPlayer.setWinsCount(currentPlayer.getWinsCount() + 1);
                        gameWin = true;
                        break;
                    }
                    endGame = false;
                }
            }

            if (gameWin) {
                break;
            } else if (endGame) {
                System.out.println("У всех игроков закончились попытки. Игра завершена.");
                for (Player currentPlayer : players) {
                    System.out.println("Числа игрока " + currentPlayer.getName() + ": " + Arrays.toString(currentPlayer.getNumbers()));
                }
                break;
            }
        } while (true);
    }

    private boolean numberGuessed(int randomNumber, Player player) {
        Scanner input = new Scanner(System.in);

        System.out.println(player.getName() + " введите загаданное число");
        int playerNumber = input.nextInt();
        player.addNumber(playerNumber);

        int number = checkNumber(randomNumber, player);

        if (number == 0) {
            System.out.println("Поздравляю " + player.getName() + " число угадано!");
            return true;
        } else if (number == 1) {
            System.out.println("Данное число больше того, что загадал компьютер");
        } else {
            System.out.println("Данное число меньше того, что загадал компьютер");
        }

        if (player.getAvailableChoice() == 0) {
            System.out.println("У игрока " + player.getName() + " закончились попытки");
        }
        return false;
    }

    private int checkNumber(int randomNumber, Player player) {
        return randomNumber == player.getLastNumber() ? 0 : player.getLastNumber() > randomNumber ? 1 : -1;
    }

    public void findWinner() {
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

    public void fillPlayers() {
        for (Player player : players) {
            player.fill();
        }
    }

    public int getGamesCount() {
        return gamesCount;
    }

    public void setGamesCount(int gamesCount) {
        this.gamesCount = gamesCount;
    }
}