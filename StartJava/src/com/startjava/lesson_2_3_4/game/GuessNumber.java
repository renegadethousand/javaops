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

    public void start() {
        while (getGamesCount() < getMaxGames()) {
            gamesCount++;
            newGame();
        }
        findWinner();
        setGamesCount(0);
        fillPlayersWinsCount();
    }

    public void newGame() {
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
                    if (numberGuessed(randomNumber, currentPlayer)) {
                        System.out.println("Числа игрока " + currentPlayer.getName() + ": " + Arrays.toString(Arrays.copyOf(currentPlayer.getNumbers(), currentPlayer.getCountChoice())));
                        currentPlayer.setCountWins(currentPlayer.getCountWins() + 1);
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
        while (!player.addNumber(playerNumber)) {
            System.out.println("Число должно входить в диапазон от 0 до 100!");
        };

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

    private int checkNumber(int randomNumber, Player player) {
        return randomNumber == player.getLastNumber() ? 0 : player.getLastNumber() > randomNumber ? 1 : -1;
    }

    public void findWinner() {
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

    public void fillPlayers() {
        for (Player player : players) {
            player.fill();
        }
    }

    public void fillPlayersWinsCount() {
        for (Player player : players) {
            player.setCountWins(0);
        }
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
}