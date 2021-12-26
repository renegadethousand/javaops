package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    public static int calculate(int firstNumber, char operation, int secondNumber) {
        switch (operation) {
            case '+' -> {
                return firstNumber + secondNumber;
            }
            case '-' -> {
                return firstNumber - secondNumber;
            }
            case '*' -> {
                return firstNumber * secondNumber;
            }
            case '/' -> {
                return firstNumber / secondNumber;
            }
            case '^' -> {
                return (int) Math.pow(firstNumber, secondNumber);
            }
            case '%' -> {
                return firstNumber % secondNumber;
            }
        }
        return 0;
    }
}