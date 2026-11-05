import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        boolean playAgain = true;

        System.out.println("      Welcome to Guess the Number!      ");

        // Outer loop to handle multiple rounds
        while (playAgain) {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("\nI have chosen a new number between " + lowerBound + " and " + upperBound + ".");
            System.out.println("Can you guess what it is?\n");

            // Inner game loop for the current round
            while (!hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a valid number.\n");
                    scanner.next(); // Consume invalid token
                    continue;
                }

                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < lowerBound || userGuess > upperBound) {
                    System.out.println("Please keep your guess within the range of " + lowerBound + " to " + upperBound + ".\n");
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try a higher number.\n");
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try a lower number.\n");
                } else {
                    hasGuessedCorrectly = true;
                    System.out.println("\n Congratulations! You found the number!");
                    System.out.println("It took you " + attempts + " attempts.");
                }
            }

            // Ask if the user wants to play another round
            System.out.print("\nWould you like to play again? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();

            if (!response.equals("yes") && !response.equals("y")) {
                playAgain = false;
                System.out.println("Thanks for playing....");
            }
        }

        scanner.close();
    }
}