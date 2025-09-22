import java.util.Scanner;

/**
 * Level 2 Problem 4: Fibonacci Sequence Generator
 * Demonstrates modular programming with function for Fibonacci calculation
 */
public class FibonacciGenerator {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Fibonacci Sequence Generator ===");

        // Get number of terms from user
        int numberOfTerms = getNumberOfTerms();

        // Generate and display Fibonacci sequence
        generateAndDisplayFibonacci(numberOfTerms);

        // Demonstrate different Fibonacci implementations
        demonstrateAlternativeImplementations(numberOfTerms);

        scanner.close();
    }

    /**
     * Get number of terms from user with validation
     * @return Valid positive integer
     */
    private static int getNumberOfTerms() {
        while (true) {
            try {
                System.out.print("Enter the number of Fibonacci terms to generate: ");
                int terms = Integer.parseInt(scanner.nextLine().trim());

                if (terms <= 0) {
                    System.out.println("Please enter a positive number.");
                    continue;
                }

                if (terms > 50) {
                    System.out.println("Warning: Large numbers may cause overflow. Consider using fewer terms.");
                    System.out.print("Continue anyway? (y/n): ");
                    String choice = scanner.nextLine().trim().toLowerCase();
                    if (!choice.equals("y") && !choice.equals("yes")) {
                        continue;
                    }
                }

                return terms;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer.");
            }
        }
    }

    /**
     * Generate and display Fibonacci sequence iteratively
     * @param n Number of terms to generate
     */
    private static void generateAndDisplayFibonacci(int n) {
        System.out.println("\n=== Fibonacci Sequence (First " + n + " terms) ===");

        long[] fibonacci = generateFibonacciArray(n);

        // Display the sequence
        System.out.print("Fibonacci Sequence: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci[i]);
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        // Display additional information
        if (n > 0) {
            System.out.println("First term: " + fibonacci[0]);
            System.out.println("Last term: " + fibonacci[n-1]);

            if (n > 1) {
                long sum = calculateFibonacciSum(fibonacci);
                System.out.println("Sum of all terms: " + sum);

                double ratio = (double) fibonacci[n-1] / fibonacci[n-2];
                System.out.println("Ratio of last two terms: " + String.format("%.6f", ratio));
                System.out.println("Golden ratio approximation: " + String.format("%.6f", (1 + Math.sqrt(5)) / 2));
            }
        }
    }

    /**
     * Generate Fibonacci sequence using iterative approach
     * @param n Number of terms
     * @return Array containing Fibonacci sequence
     */
    private static long[] generateFibonacciArray(int n) {
        long[] fibonacci = new long[n];

        if (n >= 1) fibonacci[0] = 0;
        if (n >= 2) fibonacci[1] = 1;

        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }

        return fibonacci;
    }

    /**
     * Calculate nth Fibonacci number recursively (less efficient for large n)
     * @param n The position in sequence
     * @return nth Fibonacci number
     */
    private static long fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
    }

    /**
     * Calculate nth Fibonacci number using memoization (dynamic programming)
     * @param n The position in sequence
     * @param memo Array to store computed values
     * @return nth Fibonacci number
     */
    private static long fibonacciMemoized(int n, long[] memo) {
        if (n <= 1) {
            return n;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = fibonacciMemoized(n-1, memo) + fibonacciMemoized(n-2, memo);
        return memo[n];
    }

    /**
     * Calculate nth Fibonacci number using iterative approach
     * @param n The position in sequence
     * @return nth Fibonacci number
     */
    private static long fibonacciIterative(int n) {
        if (n <= 1) return n;

        long prev2 = 0;
        long prev1 = 1;
        long current = 0;

        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }

    /**
     * Calculate sum of Fibonacci sequence
     * @param fibonacci Array of Fibonacci numbers
     * @return Sum of all numbers
     */
    private static long calculateFibonacciSum(long[] fibonacci) {
        long sum = 0;
        for (long num : fibonacci) {
            sum += num;
        }
        return sum;
    }

    /**
     * Check if a number is a Fibonacci number
     * @param num Number to check
     * @return true if number is in Fibonacci sequence
     */
    private static boolean isFibonacciNumber(long num) {
        // A number is Fibonacci if one of (5*n*n + 4) or (5*n*n - 4) is a perfect square
        long test1 = 5 * num * num + 4;
        long test2 = 5 * num * num - 4;

        return isPerfectSquare(test1) || isPerfectSquare(test2);
    }

    /**
     * Check if a number is a perfect square
     * @param num Number to check
     * @return true if number is perfect square
     */
    private static boolean isPerfectSquare(long num) {
        long sqrt = (long) Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    /**
     * Demonstrate alternative Fibonacci implementations
     * @param n Number of terms
     */
    private static void demonstrateAlternativeImplementations(int n) {
        if (n > 20) {
            System.out.println("\nSkipping performance comparison for large n (would be too slow for recursive)");
            return;
        }

        System.out.println("\n=== Performance Comparison ===");

        // Test iterative approach
        long startTime = System.nanoTime();
        long result1 = fibonacciIterative(Math.min(n-1, 10));
        long endTime = System.nanoTime();
        long iterativeTime = endTime - startTime;

        // Test recursive approach (only for small n)
        if (n <= 15) {
            startTime = System.nanoTime();
            long result2 = fibonacciRecursive(Math.min(n-1, 10));
            endTime = System.nanoTime();
            long recursiveTime = endTime - startTime;

            System.out.println("Iterative approach: " + iterativeTime + " nanoseconds");
            System.out.println("Recursive approach: " + recursiveTime + " nanoseconds");
            System.out.println("Results match: " + (result1 == result2 ? "✓ Yes" : "✗ No"));
        }

        // Test memoized approach
        startTime = System.nanoTime();
        long[] memo = new long[Math.max(n, 2)];
        long result3 = fibonacciMemoized(Math.min(n-1, 10), memo);
        endTime = System.nanoTime();
        long memoizedTime = endTime - startTime;

        System.out.println("Memoized approach: " + memoizedTime + " nanoseconds");
        System.out.println("Iterative vs Memoized match: " + (result1 == result3 ? "✓ Yes" : "✗ No"));

        // Test if last generated number is Fibonacci
        if (n > 0) {
            long[] fib = generateFibonacciArray(n);
            System.out.println("\nIs " + fib[n-1] + " a Fibonacci number? " + 
                             (isFibonacciNumber(fib[n-1]) ? "✓ Yes" : "✗ No"));
        }
    }
}