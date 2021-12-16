import java.util.*;
import java.util.Random;

public class GuessNumber {

    public void startGame(Player playerOne, Player playerTwo) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        boolean seekNumber = true;

        do {
            System.out.println(playerOne.getName() + " введите загаданное число");
            int playerOneNumber = input.nextInt();
            playerOne.setNumber(playerOneNumber);

            if (checkNumber(randomNumber, playerOneNumber)) {
                seekNumber = false;
            }

            System.out.println(playerTwo.getName() + " введите загаданное число");
            int playerTwoNumber = input.nextInt();
            playerTwo.setNumber(playerTwoNumber);

            if (checkNumber(randomNumber, playerTwoNumber)) {
                seekNumber = false;
            }
        } while (seekNumber);
    }

    public boolean checkNumber(int randomNumber, int inputNumber) {
        boolean result = false;
        if (inputNumber == randomNumber) {
            System.out.println("Поздравляю, число угадано!");
            result = true;
        } else if (inputNumber > randomNumber) {
            System.out.println("Данное число больше того, что загадал компьютер");
        } else {
            System.out.println("Данное число меньше того, что загадал компьютер");
        }
        return result;
    }
}