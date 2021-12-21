package com.startjava.lesson_2_3.calculator;

import java.util.*;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String answer = "yes";
        Scanner input = new Scanner(System.in);
        
        do {
            if (answer.equals("yes")) {
                System.out.println("Введите первое число:");
                int firstNumber = input.nextInt();
                input.nextLine();

                System.out.println("Введите знак математической операции:");
                char operation = input.nextLine().charAt(0);

                System.out.println("Введите второе число:");
                int secondNumber = input.nextInt();

                int result = calculator.calculate(firstNumber, operation, secondNumber);
                System.out.println("Результат: " + result);
            }
            System.out.println("Хотите продолжить вычисления? [yes/no]:");
            answer = input.nextLine();
        } while (!answer.equals("no"));
    }
}