package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        String answer = "yes";
        Scanner input = new Scanner(System.in);
        
        do {
            if (answer.equals("yes")) {
                System.out.print("Введите математическое выражение: ");
                String[] mathExpression = input.nextLine().split(" ");

                int firstNumber = Integer.parseInt(mathExpression[0]);
                char operation = mathExpression[1].charAt(0);
                int secondNumber = Integer.parseInt(mathExpression[2]);

                if (firstNumber < 0 || secondNumber < 0) {
                    System.out.println("Можно использовать только положительные целые числа!");
                } else {
                    int result = Calculator.calculate(firstNumber, operation, secondNumber);
                    System.out.println("Результат: " + result);
                }
            }
            System.out.println("Хотите продолжить вычисления? [yes/no]:");
            answer = input.nextLine();
        } while (!answer.equals("no"));
    }
}