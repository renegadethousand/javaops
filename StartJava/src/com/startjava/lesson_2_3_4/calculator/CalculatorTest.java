package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        String answer = "yes";
        Scanner input = new Scanner(System.in);
        
        do {
            if (answer.equals("yes")) {
                System.out.print("Введите математическое выражение: ");
                System.out.println("Результат " + Calculator.calculate(input.nextLine()));
            }
            System.out.println("Хотите продолжить вычисления? [yes/no]:");
            answer = input.nextLine();
        } while (!answer.equals("no"));
    }
}