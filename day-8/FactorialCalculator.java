import java.math.BigInteger;
import java.util.Scanner;

/**
 * Level 2 Problem 6: Factorial Using Recursion
 * Demonstrates modular programming with recursive function and input/output separation
 */
public class FactorialCalculator {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Factorial Calculator ===");

        // Get number input
        int number = getNumberInput();

        // Calculate factorial using different approaches
        long factorialRecursive = calculateFactorialRecursive(number);
        long factorialIterative = calculateFactorialIterative(number);
        BigInteger factorialBig = calculateFactorialBigInteger(number);

        // Display results
        displayResults(number, factorialRecursive, factorialIterative, factorialBig);

        // Demonstrate factorial properties
        demonstrateFactorialProperties(number);

        scanner.close();
    }

    /**
     * Get number input from user with validation
     * @return Valid non-negative integer
     */
    private static int getNumberInput() {
        while (true) {
            try {
                System.out.print("Enter a non-negative integer to calculate its factorial: ");
                int number = Integer.parseInt(scanner.nextLine().trim());

                if (number < 0) {
                    System.out.println("Factorial is not defined for negative numbers. Please enter a non-negative integer.");
                    continue;
                }

                if (number > 20) {
                    System.out.println("Warning: Factorial of numbers > 20 may cause overflow in long type.");
                    System.out.println("We'll use BigInteger for accurate calculation.");
                }

                return number;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer.");
            }
        }
    }

    /**
     * Calculate factorial using recursion
     * @param n Number to calculate factorial for
     * @return Factorial of n
     */
    private static long calculateFactorialRecursive(int n) {
        // Base case
        if (n <= 1) {
            return 1;
        }

        // Recursive case
        return n * calculateFactorialRecursive(n - 1);
    }

    /**
     * Calculate factorial using iteration (for comparison)
     * @param n Number to calculate factorial for
     * @return Factorial of n
     */
    private static long calculateFactorialIterative(int n) {
        long result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    /**
     * Calculate factorial using BigInteger to handle large numbers
     * @param n Number to calculate factorial for
     * @return Factorial of n as BigInteger
     */
    private static BigInteger calculateFactorialBigInteger(int n) {
        BigInteger result = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }

    /**
     * Calculate factorial using tail recursion (optimizable by compiler)
     * @param n Number to calculate factorial for
     * @param accumulator Accumulated result
     * @return Factorial of n
     */
    private static long calculateFactorialTailRecursive(int n, long accumulator) {
        // Base case
        if (n <= 1) {
            return accumulator;
        }

        // Tail recursive call
        return calculateFactorialTailRecursive(n - 1, n * accumulator);
    }

    /**
     * Helper method for tail recursive factorial
     * @param n Number to calculate factorial for
     * @return Factorial of n
     */
    private static long factorialTailRecursive(int n) {
        return calculateFactorialTailRecursive(n, 1);
    }

    /**
     * Calculate factorial using memoization to optimize recursive calls
     * @param n Number to calculate factorial for
     * @param memo Memoization array
     * @return Factorial of n
     */
    private static long calculateFactorialMemoized(int n, long[] memo) {
        // Base case
        if (n <= 1) {
            return 1;
        }

        // Check if already calculated
        if (memo[n] != 0) {
            return memo[n];
        }

        // Calculate and memoize
        memo[n] = n * calculateFactorialMemoized(n - 1, memo);
        return memo[n];
    }

    /**
     * Calculate the number of trailing zeros in factorial
     * @param n Number to calculate factorial for
     * @return Number of trailing zeros
     */
    private static int countTrailingZeros(int n) {
        int count = 0;

        // Count factors of 5 (factors of 2 are always more abundant)
        for (int i = 5; n / i >= 1; i *= 5) {
            count += n / i;
        }

        return count;
    }

    /**
     * Check if a number is factorial of some integer
     * @param num Number to check
     * @return The integer whose factorial is num, or -1 if not a factorial
     */
    private static int isFactorialOf(long num) {
        if (num < 1) return -1;

        long factorial = 1;
        int i = 1;

        while (factorial < num) {
            i++;
            factorial *= i;
        }

        return factorial == num ? i : -1;
    }

    /**
     * Display factorial calculation results
     * @param number Input number
     * @param factorialRecursive Result from recursive method
     * @param factorialIterative Result from iterative method
     * @param factorialBig Result from BigInteger method
     */
    private static void displayResults(int number, long factorialRecursive, 
                                     long factorialIterative, BigInteger factorialBig) {
        System.out.println("\n=== Factorial Results ===");
        System.out.println("Number: " + number);

        if (number <= 20) {
            System.out.println("Factorial (recursive): " + factorialRecursive);
            System.out.println("Factorial (iterative): " + factorialIterative);
            System.out.println("Results match: " + (factorialRecursive == factorialIterative ? "✓ Yes" : "✗ No"));
        } else {
            System.out.println("Factorial (recursive): Overflow risk - not calculated");
            System.out.println("Factorial (iterative): Overflow risk - not calculated");
        }

        System.out.println("Factorial (BigInteger): " + factorialBig);

        // Additional information
        System.out.println("\nAdditional Information:");
        System.out.println("Number of digits in " + number + "!: " + factorialBig.toString().length());
        System.out.println("Trailing zeros in " + number + "!: " + countTrailingZeros(number));

        // Performance comparison
        if (number <= 15) {
            comparePerformance(number);
        }
    }

    /**
     * Compare performance of different factorial calculation methods
     * @param n Number to test with
     */
    private static void comparePerformance(int n) {
        System.out.println("\nPerformance Comparison:");

        // Test recursive approach
        long startTime = System.nanoTime();
        long result1 = calculateFactorialRecursive(n);
        long endTime = System.nanoTime();
        long recursiveTime = endTime - startTime;

        // Test iterative approach
        startTime = System.nanoTime();
        long result2 = calculateFactorialIterative(n);
        endTime = System.nanoTime();
        long iterativeTime = endTime - startTime;

        // Test tail recursive approach
        startTime = System.nanoTime();
        long result3 = factorialTailRecursive(n);
        endTime = System.nanoTime();
        long tailRecursiveTime = endTime - startTime;

        // Test memoized approach
        startTime = System.nanoTime();
        long[] memo = new long[n + 1];
        long result4 = calculateFactorialMemoized(n, memo);
        endTime = System.nanoTime();
        long memoizedTime = endTime - startTime;

        System.out.println("Recursive: " + recursiveTime + " nanoseconds");
        System.out.println("Iterative: " + iterativeTime + " nanoseconds");
        System.out.println("Tail Recursive: " + tailRecursiveTime + " nanoseconds");
        System.out.println("Memoized: " + memoizedTime + " nanoseconds");

        boolean allMatch = (result1 == result2) && (result2 == result3) && (result3 == result4);
        System.out.println("All methods agree: " + (allMatch ? "✓ Yes" : "✗ No"));
    }

    /**
     * Demonstrate factorial properties and interesting facts
     * @param number Input number
     */
    private static void demonstrateFactorialProperties(int number) {
        System.out.println("\n=== Factorial Properties and Facts ===");

        // Show first few factorials
        System.out.println("First 10 factorials:");
        for (int i = 0; i <= 9; i++) {
            System.out.println(i + "! = " + calculateFactorialIterative(i));
        }

        // Double factorial (n!!)
        if (number <= 15) {
            long doubleFactorial = calculateDoubleFactorial(number);
            System.out.println("\nDouble factorial " + number + "!! = " + doubleFactorial);
        }

        // Subfactorial (!n) - derangements
        if (number <= 10) {
            long subfactorial = calculateSubfactorial(number);
            System.out.println("Subfactorial !" + number + " = " + subfactorial);
        }

        // Check if input factorial is factorial of some number
        if (number <= 20) {
            long fact = calculateFactorialIterative(number);
            int isFactOf = isFactorialOf(fact);
            System.out.println("\nIs " + fact + " a factorial? " + 
                             (isFactOf != -1 ? "Yes, " + isFactOf + "!" : "No"));
        }

        // Stirling's approximation
        if (number > 1) {
            double stirlingApprox = stirlingApproximation(number);
            System.out.println("\nStirling's approximation for " + number + "!: " + 
                             String.format("%.2e", stirlingApprox));
        }
    }

    /**
     * Calculate double factorial (n!! = n * (n-2) * (n-4) * ...)
     * @param n Number to calculate double factorial for
     * @return Double factorial of n
     */
    private static long calculateDoubleFactorial(int n) {
        if (n <= 0) return 1;
        if (n <= 2) return n;

        return n * calculateDoubleFactorial(n - 2);
    }

    /**
     * Calculate subfactorial (!n) - number of derangements
     * @param n Number to calculate subfactorial for
     * @return Subfactorial of n
     */
    private static long calculateSubfactorial(int n) {
        if (n == 0) return 1;
        if (n == 1) return 0;
        if (n == 2) return 1;

        return (n - 1) * (calculateSubfactorial(n - 1) + calculateSubfactorial(n - 2));
    }

    /**
     * Calculate Stirling's approximation of factorial
     * @param n Number to approximate factorial for
     * @return Stirling's approximation
     */
    private static double stirlingApproximation(int n) {
        return Math.sqrt(2 * Math.PI * n) * Math.pow(n / Math.E, n);
    }
}