package com.startjava.lesson_1.game;

public class ConditionalStatement {
    public static void main(String[] args) {
        int age = 20;
        if (age > 20) {
            System.out.println(age);
        }

        boolean male = true;
        if (male) {
            System.out.println(male);
        } else {
            System.out.println(!male);
        }

        float height = 1.80f;
        if (height < 1.80) {
            System.out.println(height);
        }

        char firstLetterInName = 'M';
        if (firstLetterInName == 'M') {
            System.out.println(firstLetterInName);         
        } else if (firstLetterInName == 'I') {
            System.out.println(firstLetterInName); 
        } else {
            System.out.println(firstLetterInName); 
        }
    }
}