import java.util.Scanner;

/**
 * Level 2 Problem 7: GCD and LCM Calculator
 * Demonstrates modular programming with separate functions for GCD and LCM calculations
 */
public class GcdLcmCalculator {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== GCD and LCM Calculator ===");

        // Get two numbers from user
        int[] numbers = getTwoNumbers();
        int num1 = numbers[0];
        int num2 = numbers[1];

        // Calculate GCD and LCM
        int gcd = calculateGCD(num1, num2);
        long lcm = calculateLCM(num1, num2);

        // Display results
        displayResults(num1, num2, gcd, lcm);

        // Demonstrate with multiple numbers
        demonstrateMultipleNumbers();

        // Show mathematical properties
        demonstrateMathematicalProperties(num1, num2, gcd, lcm);

        scanner.close();
    }

    /**
     * Get two positive integers from user
     * @return Array containing two numbers
     */
    private static int[] getTwoNumbers() {
        int num1 = getPositiveInteger("Enter first positive integer: ");
        int num2 = getPositiveInteger("Enter second positive integer: ");

        return new int[]{num1, num2};
    }

    /**
     * Get a positive integer from user with validation
     * @param prompt Message to display
     * @return Valid positive integer
     */
    private static int getPositiveInteger(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int number = Integer.parseInt(scanner.nextLine().trim());

                if (number <= 0) {
                    System.out.println("Please enter a positive integer greater than 0.");
                    continue;
                }

                return number;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer.");
            }
        }
    }

    /**
     * Calculate GCD using Euclidean algorithm (recursive)
     * @param a First number
     * @param b Second number
     * @return GCD of a and b
     */
    private static int calculateGCD(int a, int b) {
        // Base case
        if (b == 0) {
            return a;
        }

        // Recursive case
        return calculateGCD(b, a % b);
    }

    /**
     * Calculate GCD using iterative Euclidean algorithm
     * @param a First number
     * @param b Second number
     * @return GCD of a and b
     */
    private static int calculateGCDIterative(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * Calculate GCD using binary GCD algorithm (Stein's algorithm)
     * @param a First number
     * @param b Second number
     * @return GCD of a and b
     */
    private static int calculateGCDBinary(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        // Find the number of common factors of 2
        int shift = 0;
        while ((a | b) % 2 == 0) {
            a >>= 1;
            b >>= 1;
            shift++;
        }

        // Remove factors of 2 from a
        while (a % 2 == 0) {
            a >>= 1;
        }

        do {
            // Remove factors of 2 from b
            while (b % 2 == 0) {
                b >>= 1;
            }

            // Ensure a <= b
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }

            b = b - a;
        } while (b != 0);

        return a << shift;
    }

    /**
     * Calculate LCM using the relationship LCM(a,b) = (a * b) / GCD(a,b)
     * @param a First number
     * @param b Second number
     * @return LCM of a and b
     */
    private static long calculateLCM(int a, int b) {
        int gcd = calculateGCD(a, b);
        return (long) a * b / gcd;
    }

    /**
     * Calculate LCM directly without using GCD
     * @param a First number
     * @param b Second number
     * @return LCM of a and b
     */
    private static long calculateLCMDirect(int a, int b) {
        long lcm = Math.max(a, b);

        while (true) {
            if (lcm % a == 0 && lcm % b == 0) {
                return lcm;
            }
            lcm++;
        }
    }

    /**
     * Calculate GCD of multiple numbers
     * @param numbers Array of numbers
     * @return GCD of all numbers
     */
    private static int calculateGCDMultiple(int[] numbers) {
        if (numbers.length == 0) return 0;
        if (numbers.length == 1) return numbers[0];

        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result = calculateGCD(result, numbers[i]);
            if (result == 1) {
                break; // GCD cannot be smaller than 1
            }
        }

        return result;
    }

    /**
     * Calculate LCM of multiple numbers
     * @param numbers Array of numbers
     * @return LCM of all numbers
     */
    private static long calculateLCMMultiple(int[] numbers) {
        if (numbers.length == 0) return 0;
        if (numbers.length == 1) return numbers[0];

        long result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result = calculateLCM((int) result, numbers[i]);
        }

        return result;
    }

    /**
     * Check if two numbers are coprime (GCD = 1)
     * @param a First number
     * @param b Second number
     * @return true if numbers are coprime
     */
    private static boolean areCoprime(int a, int b) {
        return calculateGCD(a, b) == 1;
    }

    /**
     * Find all divisors of a number
     * @param n Number to find divisors for
     * @return Array of divisors
     */
    private static int[] findDivisors(int n) {
        int[] temp = new int[n];
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                temp[count++] = i;
            }
        }

        int[] divisors = new int[count];
        System.arraycopy(temp, 0, divisors, 0, count);
        return divisors;
    }

    /**
     * Display GCD and LCM results
     * @param num1 First number
     * @param num2 Second number
     * @param gcd Calculated GCD
     * @param lcm Calculated LCM
     */
    private static void displayResults(int num1, int num2, int gcd, long lcm) {
        System.out.println("\n=== Results ===");
        System.out.println("Numbers: " + num1 + " and " + num2);
        System.out.println("GCD (Greatest Common Divisor): " + gcd);
        System.out.println("LCM (Least Common Multiple): " + lcm);

        // Verify the relationship: num1 * num2 = GCD * LCM
        long product = (long) num1 * num2;
        long gcdLcmProduct = (long) gcd * lcm;

        System.out.println("\nVerification:");
        System.out.println(num1 + " × " + num2 + " = " + product);
        System.out.println("GCD × LCM = " + gcd + " × " + lcm + " = " + gcdLcmProduct);
        System.out.println("Identity holds: " + (product == gcdLcmProduct ? "✓ Yes" : "✗ No"));

        // Additional properties
        System.out.println("\nAdditional Properties:");
        System.out.println("Are coprime (GCD = 1): " + (areCoprime(num1, num2) ? "Yes" : "No"));
        System.out.println("Ratio " + num1 + "/" + num2 + " simplified: " + 
                          (num1/gcd) + "/" + (num2/gcd));

        // Show divisors
        int[] divisors1 = findDivisors(num1);
        int[] divisors2 = findDivisors(num2);

        System.out.println("\nDivisors of " + num1 + ": " + java.util.Arrays.toString(divisors1));
        System.out.println("Divisors of " + num2 + ": " + java.util.Arrays.toString(divisors2));
    }

    /**
     * Demonstrate GCD and LCM calculation with multiple numbers
     */
    private static void demonstrateMultipleNumbers() {
        System.out.println("\n=== Multiple Numbers Example ===");

        int[] testNumbers = {12, 18, 24, 30};
        int gcdMultiple = calculateGCDMultiple(testNumbers);
        long lcmMultiple = calculateLCMMultiple(testNumbers);

        System.out.print("Numbers: ");
        for (int i = 0; i < testNumbers.length; i++) {
            System.out.print(testNumbers[i]);
            if (i < testNumbers.length - 1) System.out.print(", ");
        }
        System.out.println();

        System.out.println("GCD of all numbers: " + gcdMultiple);
        System.out.println("LCM of all numbers: " + lcmMultiple);
    }

    /**
     * Demonstrate mathematical properties and alternative algorithms
     * @param num1 First number
     * @param num2 Second number
     * @param gcd Calculated GCD
     * @param lcm Calculated LCM
     */
    private static void demonstrateMathematicalProperties(int num1, int num2, int gcd, long lcm) {
        System.out.println("\n=== Algorithm Comparison ===");

        // Compare different GCD algorithms
        long startTime, endTime;

        startTime = System.nanoTime();
        int gcdRecursive = calculateGCD(num1, num2);
        endTime = System.nanoTime();
        long recursiveTime = endTime - startTime;

        startTime = System.nanoTime();
        int gcdIterative = calculateGCDIterative(num1, num2);
        endTime = System.nanoTime();
        long iterativeTime = endTime - startTime;

        startTime = System.nanoTime();
        int gcdBinary = calculateGCDBinary(num1, num2);
        endTime = System.nanoTime();
        long binaryTime = endTime - startTime;

        startTime = System.nanoTime();
        long lcmDirect = calculateLCMDirect(num1, num2);
        endTime = System.nanoTime();
        long directLcmTime = endTime - startTime;

        System.out.println("GCD Algorithms:");
        System.out.println("Recursive Euclidean: " + recursiveTime + " ns, result: " + gcdRecursive);
        System.out.println("Iterative Euclidean: " + iterativeTime + " ns, result: " + gcdIterative);
        System.out.println("Binary (Stein's): " + binaryTime + " ns, result: " + gcdBinary);

        System.out.println("\nLCM Algorithms:");
        System.out.println("Using GCD formula: Fast, result: " + lcm);
        System.out.println("Direct method: " + directLcmTime + " ns, result: " + lcmDirect);

        // Verify all algorithms give same result
        boolean gcdMatch = (gcdRecursive == gcdIterative) && (gcdIterative == gcdBinary);
        boolean lcmMatch = (lcm == lcmDirect);

        System.out.println("\nAll GCD algorithms agree: " + (gcdMatch ? "✓ Yes" : "✗ No"));
        System.out.println("All LCM algorithms agree: " + (lcmMatch ? "✓ Yes" : "✗ No"));
    }
}