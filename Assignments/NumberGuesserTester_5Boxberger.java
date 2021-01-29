import java.util.Scanner;

public class NumberGuesserTester_5Boxberger {
    public static void main(String[] args) {
        NumberGuesser game = new NumberGuesser();
        game.play();

        NumberGuesser game2 = new NumberGuesser(150);
        game2.play();
    }
}

class NumberGuesser {
    private int targetNumber;
    Scanner input = new Scanner(System.in);
    private String guess;
    private int attempts = 1;
    private int maximumNumber;

    // constructors
    public NumberGuesser() {
        maximumNumber = 10;
        targetNumber = (int) (Math.random() * maximumNumber);
    }

    public NumberGuesser(int max) {
        maximumNumber = max;
        targetNumber = (int) (Math.random() * maximumNumber);
    }

    // methods
    public void play() {
        System.out.println("I have chosen a random value between 1 and " + maximumNumber + ". Try to guess what number I chose!");
        while (true) {
            System.out.print("Enter a guess: ");
            guess = input.nextLine();
            if (Integer.valueOf(guess) == targetNumber) {
                System.out.println("You guessed it! The number was " + targetNumber);
                System.out.println("It took you " + attempts + " tries to find my number\n");
                return;
            } else if (Integer.valueOf(guess) < targetNumber) {
                System.out.println("Your guess was too low!");
                attempts++;
            } else {
                System.out.println("Your guess was too high!");
                attempts++;
            }
        }
    }
}