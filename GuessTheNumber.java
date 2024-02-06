import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        System.out.println("Welcome to the Guess the Number game!");

        while (true) {
            playGame();

            // Ask if the user wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            try (Scanner scanner = new Scanner(System.in)) {
                String playAgain = scanner.nextLine().toLowerCase();

                if (!playAgain.equals("yes")) {
                    break;
                }
            }
        }
    }

    public static void playGame() {
        // Step 1: Generate a random number within the specified range
        int targetNumber = (int) (Math.random() * 100) + 1;
        int attemptsLimit = 10;
        int attemptsTaken = 0;

        try (// Step 2 and 3: Prompt the user to guess and provide feedback
        Scanner scanner = new Scanner(System.in)) {
            while (attemptsTaken < attemptsLimit) {
                System.out.print("Guess the number (between 1 and 100): ");
                int userGuess = scanner.nextInt();
                attemptsTaken++;

                // Step 3: Compare the user's guess and provide feedback
                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number " + targetNumber +
                            " in " + attemptsTaken + " attempts.");
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }
        }
        // Step 5: Limit the number of attempts
        if (attemptsTaken == attemptsLimit) {
            System.out.println("Sorry, you've reached the maximum number of attempts. " +
                    "The correct number was " + targetNumber + ".");
        }
    }
}