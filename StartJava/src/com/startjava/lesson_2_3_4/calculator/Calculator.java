package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    public static int calculate(String mathExpression) {
        String[] expressionParts = mathExpression.split(" ");

        int firstNumber = Integer.parseInt(expressionParts[0]);
        char operation = expressionParts[1].charAt(0);
        int secondNumber = Integer.parseInt(expressionParts[2]);

        if (firstNumber < 0 || secondNumber < 0) {
            System.out.println("Можно использовать только положительные целые числа!");
            return 0;
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

        return result;
    }
}