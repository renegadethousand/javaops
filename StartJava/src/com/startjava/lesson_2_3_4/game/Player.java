package com.startjava.lesson_2_3_4.game;

import java.util.Arrays;

public class Player {

    private String name;
    private int[] numbers;
    private int choiceCount;
    private int winsCount;

    public Player(String name, int choicesAmount) {
        this.name = name;
        this.numbers = new int[choicesAmount];
    }

    public int getWinsCount() {
        return winsCount;
    }

    public void setWinsCount(int winsCount) {
        this.winsCount = winsCount;
    }

    public String getName() {
        return name;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public void addNumber(int number) {
        if (number >= 0 && number <= 100) {
            this.numbers[choiceCount] = number;
            choiceCount++;
        } else {
            System.out.println("Число должно входить в диапазон от 0 до 100!");
        }
    }

    public int getLastNumber() {
        if (choiceCount == 0) {
            return 0;
        }
        return numbers[choiceCount - 1];
    }

    public int getAvailableChoice() {
        return numbers.length - choiceCount;
    }

    public int getChoiceCount() {
        return choiceCount;
    }

    public void setChoiceCount(int choiceCount) {
        this.choiceCount = choiceCount;
    }

    public void fill() {
        Arrays.fill(numbers, choiceCount);
        setChoiceCount(0);
    }
}