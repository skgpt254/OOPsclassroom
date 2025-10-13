import java.util.Random;
import java.util.Scanner;

/**
 * Level 2 Problem 1: Number Guessing Game
 * Computer tries to guess a number between 1 and 100 that user thinks of
 * Demonstrates modular programming with separate functions
 */
public class NumberGuessingGame {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("=== Number Guessing Game ===");
        System.out.println("Think of a number between " + MIN_NUMBER + " and " + MAX_NUMBER);
        System.out.println("I will try to guess it!");
        System.out.println("Respond with 'h' (too high), 'l' (too low), or 'c' (correct)");
        System.out.println("Press Enter when ready...");
        scanner.nextLine();

        playGame();

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    /**
     * Main game loop - coordinates the guessing process
     */
    private static void playGame() {
        int low = MIN_NUMBER;
        int high = MAX_NUMBER;
        int attempts = 0;
        boolean gameWon = false;

        while (!gameWon && low <= high) {
            attempts++;

            // Generate guess using binary search strategy
            int guess = generateGuess(low, high);

            // Get user feedback
            char feedback = getUserFeedback(guess, attempts);

            // Process feedback and update range
            if (feedback == 'c') {
                gameWon = true;
                displayWinMessage(attempts);
            } else {
                int[] newRange = updateRange(low, high, guess, feedback);
                low = newRange[0];
                high = newRange[1];

                if (low > high) {
                    displayErrorMessage();
                    break;
                }
            }
        }

        if (!gameWon && low > high) {
            System.out.println("Something went wrong! Please check your responses.");
        }
    }

    /**
     * Generate the next guess using binary search strategy
     * @param low Current lower bound
     * @param high Current upper bound
     * @return The next guess
     */
    private static int generateGuess(int low, int high) {
        // Use binary search for efficient guessing
        return low + (high - low) / 2;
    }

    /**
     * Get feedback from user about the guess
     * @param guess The computer's guess
     * @param attemptNumber Current attempt number
     * @return User's feedback ('h', 'l', or 'c')
     */
    private static char getUserFeedback(int guess, int attemptNumber) {
        while (true) {
            System.out.printf("Attempt %d: My guess is %d. Is it (h)igh, (l)ow, or (c)orrect? ", 
                            attemptNumber, guess);
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.length() == 1) {
                char feedback = input.charAt(0);
                if (feedback == 'h' || feedback == 'l' || feedback == 'c') {
                    return feedback;
                }
            }

            System.out.println("Please enter 'h' for high, 'l' for low, or 'c' for correct.");
        }
    }

    /**
     * Update the search range based on user feedback
     * @param low Current lower bound
     * @param high Current upper bound
     * @param guess The guess that was made
     * @param feedback User's feedback
     * @return Array containing new [low, high] bounds
     */
    private static int[] updateRange(int low, int high, int guess, char feedback) {
        if (feedback == 'h') {
            // Guess was too high, so the number is lower
            high = guess - 1;
            System.out.println("Got it! The number is between " + low + " and " + high);
        } else if (feedback == 'l') {
            // Guess was too low, so the number is higher
            low = guess + 1;
            System.out.println("Got it! The number is between " + low + " and " + high);
        }

        return new int[]{low, high};
    }

    /**
     * Display win message
     * @param attempts Number of attempts taken
     */
    private static void displayWinMessage(int attempts) {
        System.out.println("\n🎉 Excellent! I guessed your number!");
        System.out.println("It took me " + attempts + " attempts.");

        // Calculate efficiency
        int maxAttempts = (int) Math.ceil(Math.log(MAX_NUMBER - MIN_NUMBER + 1) / Math.log(2));
        System.out.println("Maximum possible attempts with binary search: " + maxAttempts);

        if (attempts <= maxAttempts) {
            System.out.println("That's optimal performance! 🎯");
        }
    }

    /**
     * Display error message when user responses are inconsistent
     */
    private static void displayErrorMessage() {
        System.out.println("\n❌ Error: Your responses seem inconsistent.");
        System.out.println("Please make sure you're giving correct feedback:");
        System.out.println("- 'h' if my guess is higher than your number");
        System.out.println("- 'l' if my guess is lower than your number");
        System.out.println("- 'c' if my guess is correct");
    }

    /**
     * Alternative random guessing strategy (less efficient)
     * @param low Current lower bound
     * @param high Current upper bound
     * @return Random guess within range
     */
    private static int generateRandomGuess(int low, int high) {
        return random.nextInt(high - low + 1) + low;
    }
}