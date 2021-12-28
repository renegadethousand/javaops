package com.startjava.lesson_2_3_4.game;

import java.util.Arrays;

public class Player {

    private String name;
    private int[] numbers;
    private int countChoice;
    private int countWins;

    public Player(String name, int choicesAmount) {
        this.name = name;
        this.numbers = new int[choicesAmount];
    }

    public String getName() {
        return name;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, numbers.length);
    }

    public boolean addNumber(int number) {
        if (number >= 0 && number <= 100) {
            numbers[countChoice] = number;
            countChoice++;
            return true;
        } else {
            return false;
        }
    }

    public int getCountChoice() {
        return countChoice;
    }

    public void setCountChoice(int choiceCount) {
        this.countChoice = choiceCount;
    }

    public int getCountWins() {
        return countWins;
    }

    public void setCountWins(int winsCount) {
        this.countWins = winsCount;
    }

    public int getLastNumber() {
        if (countChoice == 0) {
            return 0;
        }
        return numbers[countChoice - 1];
    }

    public int getAvailableChoice() {
        return numbers.length - countChoice;
    }

    public void fill() {
        Arrays.fill(numbers, countChoice);
        setCountChoice(0);
    }
}