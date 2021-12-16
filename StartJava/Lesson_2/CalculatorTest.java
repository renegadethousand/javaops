import java.util.*;

public class CalculatorTest {
    public static void main(String[] args) {
        boolean repeat = true;
        Calculator calculator = new Calculator();
        String continueAnswer = "";
        Scanner input = new Scanner(System.in);
        
        do {
            System.out.println("Введите знак математической операции:");
            char operation = input.nextLine().charAt(0);

            System.out.println("Введите первое число:");
            int firstNumber = input.nextInt();

            System.out.println("Введите второе число:");
            int secondNumber = input.nextInt();

            int result = calculator.calculate(firstNumber, operation, secondNumber);
            System.out.println("Результат: "+ result);

            do {
                System.out.println("Хотите продолжить вычисления? [yes/no]:");
                continueAnswer = input.nextLine();
            } while (!continueAnswer.equals("yes") && !continueAnswer.equals("no"));

            if (continueAnswer.equals("no")) {
                repeat = false;
            }
        }
        while (repeat);
    }
}