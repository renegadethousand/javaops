import java.util.*;
import java.util.Random;

public class GuessNumber {

    private Player playerOne;
    private Player playerTwo;

    public GuessNumber(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void start() {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int randomNumber = random.nextInt(101);

        do {
            System.out.println(playerOne.getName() + " введите загаданное число");
            int playerOneNumber = input.nextInt();
            playerOne.setNumber(playerOneNumber);

            if (checkNumber(randomNumber, playerOneNumber)) {
                break;
            }

            System.out.println(playerTwo.getName() + " введите загаданное число");
            int playerTwoNumber = input.nextInt();
            playerTwo.setNumber(playerTwoNumber);

            if (checkNumber(randomNumber, playerTwoNumber)) {
                break;
            }
        } while (true);
    }

    private boolean checkNumber(int randomNumber, int inputNumber) {
        if (inputNumber == randomNumber) {
            System.out.println("Поздравляю, число угадано!");
            return true;
        } else if (inputNumber > randomNumber) {
            System.out.println("Данное число больше того, что загадал компьютер");
        } else {
            System.out.println("Данное число меньше того, что загадал компьютер");
        }
        return false;
    }
}