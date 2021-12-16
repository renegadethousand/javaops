import java.util.*;

public class GuessNumberTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean repeat = true;
        String continueAnswer = "";

        System.out.println("Введиите имя игрока 1");
        String playerOneName = input.nextLine();
        Player playerOne = new Player(playerOneName);

        System.out.println("Введиите имя игрока 2");
        String playerTwoName = input.nextLine();
        Player playerTwo = new Player(playerTwoName);

        GuessNumber guessNumber = new GuessNumber();

        do {
            guessNumber.startGame(playerOne, playerTwo);

            do {
                System.out.println("Хотите продолжить игру? [yes/no]:");
                continueAnswer = input.nextLine();
            } while (!continueAnswer.equals("yes") && !continueAnswer.equals("no"));

            if (continueAnswer.equals("no")) {
                repeat = false;
            }
        } while (repeat);
    }
}