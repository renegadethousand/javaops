public class Calculator {

    public int calculate(int firstNumber, char operation, int secondNumber) {
        switch (operation) {
            case '+':
                return firstNumber + secondNumber;
            case '-':
                return firstNumber - secondNumber;
            case '*':
                return firstNumber * secondNumber;
            case '/':
                return firstNumber / secondNumber;
            case '^':
                int result = firstNumber;
                for (int i = 1; i < secondNumber; i++) {
                    result *= firstNumber;
                }
                return result;
            case '%':
                return firstNumber % secondNumber;
        }
        return 0;
    }
}