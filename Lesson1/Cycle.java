public class Cycle {
    public static void main(String[] args) {       
        for (int i = 0; i <= 20; i++) {
            System.out.println(i);
        }

        int number = 6;
        while (number > -7) {
            System.out.println(number);
            number -= 2;
        }

        int counter = 10;
        int sumOdd = 0;
        do {         
            if (counter % 2 != 0) {
                sumOdd += counter;
            }
            counter++;
        } while (counter < 20);
        System.out.println(sumOdd);
    }
}