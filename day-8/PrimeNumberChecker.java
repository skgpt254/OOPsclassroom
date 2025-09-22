import java.util.Scanner;

/**
 * Level 2 Problem 3: Prime Number Checker
 * Demonstrates modular programming with separate function for prime checking
 */
public class PrimeNumberChecker {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Prime Number Checker ===");

        // Get number input
        int number = getNumberInput();

        // Check if prime
        boolean isPrime = isPrimeNumber(number);

        // Display result
        displayPrimeResult(number, isPrime);

        // Show additional information
        displayAdditionalInfo(number);

        // Demonstrate prime checking for a range
        demonstratePrimeRange();

        scanner.close();
    }

    /**
     * Get number input from user with validation
     * @return Valid positive integer
     */
    private static int getNumberInput() {
        while (true) {
            try {
                System.out.print("Enter a positive integer to check if it's prime: ");
                int number = Integer.parseInt(scanner.nextLine().trim());

                if (number < 2) {
                    System.out.println("Please enter a number greater than 1 (2 is the smallest prime).");
                    continue;
                }

                return number;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer.");
            }
        }
    }

    /**
     * Check if a number is prime using efficient algorithm
     * @param n The number to check
     * @return true if number is prime, false otherwise
     */
    private static boolean isPrimeNumber(int n) {
        // Handle special cases
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        // Check odd divisors up to sqrt(n)
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Alternative prime checking method using trial division
     * @param n The number to check
     * @return true if number is prime, false otherwise
     */
    private static boolean isPrimeSimple(int n) {
        if (n < 2) return false;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Optimized prime checking for small numbers
     * @param n The number to check
     * @return true if number is prime, false otherwise
     */
    private static boolean isPrimeOptimized(int n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        // Check divisors of form 6k ± 1
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Display prime checking result
     * @param number The number that was checked
     * @param isPrime Whether the number is prime
     */
    private static void displayPrimeResult(int number, boolean isPrime) {
        System.out.println("\n=== Prime Check Result ===");
        System.out.println("Number: " + number);

        if (isPrime) {
            System.out.println("✓ " + number + " IS a prime number!");
            System.out.println("Prime numbers are only divisible by 1 and themselves.");
        } else {
            System.out.println("✗ " + number + " is NOT a prime number.");
            System.out.print("Factors of " + number + ": ");
            displayFactors(number);
        }
    }

    /**
     * Display all factors of a number
     * @param n The number to find factors for
     */
    private static void displayFactors(int n) {
        System.out.print("1");
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(", " + i);
            }
        }
        System.out.println();
    }

    /**
     * Find the smallest prime factor of a number
     * @param n The number to find the smallest prime factor for
     * @return The smallest prime factor
     */
    private static int findSmallestPrimeFactor(int n) {
        if (n < 2) return -1;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return i;
            }
        }

        return n; // n itself is prime
    }

    /**
     * Display additional information about the number
     * @param number The number to analyze
     */
    private static void displayAdditionalInfo(int number) {
        System.out.println("\n=== Additional Information ===");

        // Check if even or odd
        System.out.println("Even/Odd: " + (number % 2 == 0 ? "Even" : "Odd"));

        // Find smallest prime factor
        int smallestFactor = findSmallestPrimeFactor(number);
        if (smallestFactor != number) {
            System.out.println("Smallest prime factor: " + smallestFactor);
        }

        // Check if perfect square
        int sqrt = (int) Math.sqrt(number);
        boolean isPerfectSquare = sqrt * sqrt == number;
        System.out.println("Perfect square: " + (isPerfectSquare ? "Yes" : "No"));

        // Compare different prime checking methods
        long startTime, endTime;

        startTime = System.nanoTime();
        boolean result1 = isPrimeNumber(number);
        endTime = System.nanoTime();
        long time1 = endTime - startTime;

        startTime = System.nanoTime();
        boolean result2 = isPrimeOptimized(number);
        endTime = System.nanoTime();
        long time2 = endTime - startTime;

        System.out.println("\nPerformance Comparison:");
        System.out.println("Standard method: " + time1 + " nanoseconds");
        System.out.println("Optimized method: " + time2 + " nanoseconds");
        System.out.println("Results match: " + (result1 == result2 ? "✓ Yes" : "✗ No"));
    }

    /**
     * Demonstrate prime checking for a range of numbers
     */
    private static void demonstratePrimeRange() {
        System.out.println("\n=== Prime Numbers 2-50 ===");
        System.out.print("Prime numbers: ");

        for (int i = 2; i <= 50; i++) {
            if (isPrimeNumber(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        // Count primes in range
        int primeCount = 0;
        for (int i = 2; i <= 50; i++) {
            if (isPrimeNumber(i)) {
                primeCount++;
            }
        }
        System.out.println("Total primes between 2-50: " + primeCount);
    }
}