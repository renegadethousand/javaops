package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    public static void calculate(String mathExpression) {

        String[] mathOperation = mathExpression.split(" ");

        int firstNumber = Integer.parseInt(mathOperation[0]);
        char operation = mathOperation[1].charAt(0);
        int secondNumber = Integer.parseInt(mathOperation[2]);

        if (firstNumber < 0 || secondNumber < 0) {
            System.out.println("Можно использовать только положительные целые числа!");
            return;
        }

        int result = switch (operation) {
            case '+' -> firstNumber + secondNumber;
            case '-' -> firstNumber - secondNumber;
            case '*' -> firstNumber * secondNumber;
            case '/' -> firstNumber / secondNumber;
            case '^' -> (int) Math.pow(firstNumber, secondNumber);
            case '%' -> firstNumber % secondNumber;
            default -> 0;
        };

        System.out.println("Результат: " + result);
    }
}