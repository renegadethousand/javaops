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
        return Arrays.copyOf(numbers, countChoice);
    }

    public boolean addNumber(int number) {
        if (number >= 0 && number <= 100) {
            numbers[countChoice] = number;
            countChoice++;
            return true;
        }
        return false;
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

    public void incWin() {
        countWins++;
    }

    public int getLastNumber() {
        return countChoice == 0 ? 0 : numbers[countChoice - 1];
    }

    public int getAvailableChoice() {
        return numbers.length - countChoice;
    }

    public void fill() {
        Arrays.fill(numbers, 0, countChoice == 0 ? 0 : countChoice - 1, 0);
        setCountChoice(0);
    }
}