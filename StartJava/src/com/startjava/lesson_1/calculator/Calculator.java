package com.startjava.lesson_1.calculator;

import java.util.*;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Input operation"); 
        char operation = input.nextLine().charAt(0);

        System.out.println("Input first number"); 
        int firstNumber = input.nextInt();

        System.out.println("Input second number"); 
        int secondNumber = input.nextInt();

        int result = 0;
        if (operation == '+') {
            result = firstNumber + secondNumber;
        } else if (operation == '-') {
            result = firstNumber - secondNumber;
        } else if (operation == '*') {
            result = firstNumber * secondNumber;
        } else if (operation == '/') {
            result = firstNumber / secondNumber;
        } else if (operation == '^') {
            result = firstNumber;
            for (int i = 1; i < secondNumber; i++) {
                result *= firstNumber;
            }
        } else if (operation == '%') {
            result = firstNumber % secondNumber;
        }
        System.out.println(result);
    }
}