import java.util.Scanner;

/**
 * Level 2 Problem 2: Maximum of Three Numbers
 * Demonstrates modular programming with separate functions for input and calculation
 */
public class MaximumOfThree {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Maximum of Three Numbers ===");

        // Get three numbers using modular input function
        int num1 = getIntegerInput("Enter first number: ");
        int num2 = getIntegerInput("Enter second number: ");
        int num3 = getIntegerInput("Enter third number: ");

        // Calculate maximum using modular calculation function
        int maximum = findMaximum(num1, num2, num3);

        // Display results using modular display function
        displayResults(num1, num2, num3, maximum);

        // Demonstrate alternative approaches
        demonstrateAlternativeApproaches(num1, num2, num3);

        scanner.close();
    }

    /**
     * Get integer input from user with validation
     * @param prompt Message to display to user
     * @return Valid integer input
     */
    private static int getIntegerInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer.");
            }
        }
    }

    /**
     * Find maximum of three numbers using conditional statements
     * @param a First number
     * @param b Second number
     * @param c Third number
     * @return Maximum of the three numbers
     */
    private static int findMaximum(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        } else {
            return c;
        }
    }

    /**
     * Alternative maximum calculation using Math.max()
     * @param a First number
     * @param b Second number
     * @param c Third number
     * @return Maximum of the three numbers
     */
    private static int findMaximumUsingMath(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    /**
     * Alternative maximum calculation using ternary operators
     * @param a First number
     * @param b Second number
     * @param c Third number
     * @return Maximum of the three numbers
     */
    private static int findMaximumUsingTernary(int a, int b, int c) {
        return (a >= b) ? ((a >= c) ? a : c) : ((b >= c) ? b : c);
    }

    /**
     * Find maximum and minimum simultaneously
     * @param a First number
     * @param b Second number
     * @param c Third number
     * @return Array containing [max, min]
     */
    private static int[] findMaxAndMin(int a, int b, int c) {
        int max = findMaximum(a, b, c);
        int min = Math.min(Math.min(a, b), c);
        return new int[]{max, min};
    }

    /**
     * Display the results in a formatted manner
     * @param num1 First number
     * @param num2 Second number
     * @param num3 Third number
     * @param maximum The calculated maximum
     */
    private static void displayResults(int num1, int num2, int num3, int maximum) {
        System.out.println("\n=== Results ===");
        System.out.println("Numbers entered: " + num1 + ", " + num2 + ", " + num3);
        System.out.println("Maximum value: " + maximum);

        // Show which number(s) are maximum
        System.out.print("Maximum number(s): ");
        if (num1 == maximum) System.out.print(num1 + " ");
        if (num2 == maximum) System.out.print(num2 + " ");
        if (num3 == maximum) System.out.print(num3 + " ");
        System.out.println();

        // Additional statistics
        int sum = num1 + num2 + num3;
        double average = sum / 3.0;
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + String.format("%.2f", average));
    }

    /**
     * Demonstrate alternative approaches to finding maximum
     * @param num1 First number
     * @param num2 Second number
     * @param num3 Third number
     */
    private static void demonstrateAlternativeApproaches(int num1, int num2, int num3) {
        System.out.println("\n=== Alternative Approaches ===");

        int maxUsingMath = findMaximumUsingMath(num1, num2, num3);
        int maxUsingTernary = findMaximumUsingTernary(num1, num2, num3);
        int[] maxMin = findMaxAndMin(num1, num2, num3);

        System.out.println("Using Math.max(): " + maxUsingMath);
        System.out.println("Using ternary operator: " + maxUsingTernary);
        System.out.println("Max and Min together: Max=" + maxMin[0] + ", Min=" + maxMin[1]);

        // Verify all methods give same result
        boolean allEqual = (findMaximum(num1, num2, num3) == maxUsingMath) &&
                          (maxUsingMath == maxUsingTernary) &&
                          (maxUsingTernary == maxMin[0]);

        System.out.println("All methods agree: " + (allEqual ? "✓ Yes" : "✗ No"));
    }

    /**
     * Utility method to find maximum of an array (for extensibility)
     * @param numbers Array of numbers
     * @return Maximum value in array
     */
    private static int findMaximumInArray(int[] numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }
}