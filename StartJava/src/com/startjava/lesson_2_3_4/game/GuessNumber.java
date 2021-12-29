package com.startjava.lesson_2_3_4.game;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class GuessNumber {

    private Player[] players;
    private int gamesCount;
    private int maxGames;

    public GuessNumber(Player[] players, int maxGames) {
        this.players = players;
        this.maxGames = maxGames;
    }

    public int getGamesCount() {
        return gamesCount;
    }

    public void setGamesCount(int gamesCount) {
        this.gamesCount = gamesCount;
    }

    public int getMaxGames() {
        return maxGames;
    }

    public void start() {
        while (getGamesCount() < getMaxGames()) {
            gamesCount++;
            newGame();
        }
        findWinner();
        setGamesCount(0);
        fillPlayersWinsCount();
    }

    private void newGame() {
        Random random = new Random();
        int randomNumber = random.nextInt(101);

        fillPlayers();
        shufflePlayers();

        System.out.println("Загадано число: " + randomNumber);

        System.out.println("У каждого игрока по " + players[0].getNumbers().length + " попыток");

        do {
            boolean gameWin = false;
            boolean endGame = true;

            for (Player currentPlayer : players) {
                if (currentPlayer.getAvailableChoice() > 0) {
                    if (guessedNumber(randomNumber, currentPlayer)) {
                        currentPlayer.incWin();
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
                break;
            }

            for (Player currentPlayer : players) {
                printPlayerNumbers(currentPlayer);
            }
        } while (true);
    }

    private void fillPlayers() {
        for (Player player : players) {
            player.fill();
        }
    }

    private void shufflePlayers() {
        Random random = new Random();
        int firstPosition = random.nextInt(players.length);
        int secondPosition = random.nextInt(players.length);
        System.out.println("Бросаем жребий...");

        System.out.println("Первым ходит: " +  players[firstPosition].getName());

        if (firstPosition > 0) {
            Player switchedPlayer = players[0];
            players[0] = players[firstPosition];
            players[firstPosition] = switchedPlayer;
            switchedPlayer = players[1];
            players[1] = players[secondPosition];
            players[secondPosition] = switchedPlayer;
        }

        System.out.println("Порядок угадывания следующий:");
        for (Player player: players) {
            System.out.println(player.getName());
        }
    }

    private boolean guessedNumber(int randomNumber, Player player) {
        Scanner input = new Scanner(System.in);

        System.out.println(player.getName() + " введите загаданное число");
        int playerNumber = input.nextInt();
        while (!player.addNumber(playerNumber)) {
            System.out.println("Число должно входить в диапазон от 0 до 100!");
        };

        if (player.getLastNumber() == randomNumber) {
            System.out.println("Поздравляю " + player.getName() + " число угадано!");
            return true;
        } else if (player.getLastNumber() < randomNumber) {
            System.out.println("Данное число больше того, что загадал компьютер");
        } else {
            System.out.println("Данное число меньше того, что загадал компьютер");
        }

        if (player.getAvailableChoice() == 0) {
            System.out.println("У игрока " + player.getName() + " закончились попытки");
        }
        return false;
    }

    private void findWinner() {
        int[] numbers = new int[players.length];
        for (int i = 0; i < players.length; i++) {
            numbers[i] = players[i].getCountWins();
        }

        Arrays.sort(numbers);

        int maxNumber = numbers[numbers.length-1];

        if (maxNumber == 0 || numbers.length > 1 && maxNumber == numbers[numbers.length-2]) {
            System.out.println("Победителя выявить неудалось");
        } else {
            for (Player player : players) {
                if (maxNumber == player.getCountWins()) {
                    System.out.println("Победитель игрок: " + player.getName());
                }
            }
        }

        System.out.println("Статистика");
        for (Player player : players) {
            System.out.println("Игрок: " + player.getName() + ", количество побед: " + player.getCountWins());
        }
    }

    private void printPlayerNumbers(Player player) {
        System.out.print("Числа игрока " + player.getName() + ": ");
        for (int i = 0; i < player.getNumbers().length; i++) {
            System.out.print(player.getNumbers()[i] + " ");
        }
    }

    private void fillPlayersWinsCount() {
        for (Player player : players) {
            player.setCountWins(0);
        }
    }
}