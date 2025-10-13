import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * Level 2 Problem 9: Basic Calculator
 * Demonstrates modular programming with separate functions for each operation
 */
public class BasicCalculator {
    private static Scanner scanner = new Scanner(System.in);
    private static DecimalFormat df = new DecimalFormat("#.##########");

    public static void main(String[] args) {
        System.out.println("=== Basic Calculator ===");

        boolean continueCalculating = true;

        while (continueCalculating) {
            // Display menu
            displayMenu();

            // Get operation choice
            int choice = getOperationChoice();

            // Perform calculation
            performCalculation(choice);

            // Ask if user wants to continue
            continueCalculating = askToContinue();
        }

        System.out.println("\nThank you for using the calculator!");
        scanner.close();
    }

    /**
     * Display calculator menu
     */
    private static void displayMenu() {
        System.out.println("\n=== Calculator Operations ===");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (×)");
        System.out.println("4. Division (÷)");
        System.out.println("5. Power (^)");
        System.out.println("6. Square Root (√)");
        System.out.println("7. Percentage (%)");
        System.out.println("8. Factorial (!)");
        System.out.println("9. Modulo (mod)");
        System.out.println("10. Scientific Calculator");
        System.out.println("0. Exit");
    }

    /**
     * Get operation choice from user
     * @return Valid operation choice
     */
    private static int getOperationChoice() {
        while (true) {
            try {
                System.out.print("\nSelect operation (0-10): ");
                int choice = Integer.parseInt(scanner.nextLine().trim());

                if (choice >= 0 && choice <= 10) {
                    return choice;
                }

                System.out.println("Please enter a number between 0 and 10.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }
    }

    /**
     * Get numeric input from user
     * @param prompt Message to display
     * @return Valid double value
     */
    private static double getNumberInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }
    }

    /**
     * Perform calculation based on user choice
     * @param choice Operation choice
     */
    private static void performCalculation(int choice) {
        if (choice == 0) {
            return; // Exit
        }

        double num1, num2, result;

        switch (choice) {
            case 1: // Addition
                num1 = getNumberInput("Enter first number: ");
                num2 = getNumberInput("Enter second number: ");
                result = add(num1, num2);
                displayResult(num1, num2, result, "+");
                break;

            case 2: // Subtraction
                num1 = getNumberInput("Enter first number: ");
                num2 = getNumberInput("Enter second number: ");
                result = subtract(num1, num2);
                displayResult(num1, num2, result, "-");
                break;

            case 3: // Multiplication
                num1 = getNumberInput("Enter first number: ");
                num2 = getNumberInput("Enter second number: ");
                result = multiply(num1, num2);
                displayResult(num1, num2, result, "×");
                break;

            case 4: // Division
                num1 = getNumberInput("Enter dividend: ");
                num2 = getNumberInput("Enter divisor: ");
                if (num2 == 0) {
                    System.out.println("Error: Division by zero is undefined!");
                } else {
                    result = divide(num1, num2);
                    displayResult(num1, num2, result, "÷");

                    // Show additional division info
                    showDivisionInfo(num1, num2, result);
                }
                break;

            case 5: // Power
                num1 = getNumberInput("Enter base: ");
                num2 = getNumberInput("Enter exponent: ");
                result = power(num1, num2);
                displayPowerResult(num1, num2, result);
                break;

            case 6: // Square Root
                num1 = getNumberInput("Enter number: ");
                if (num1 < 0) {
                    System.out.println("Error: Square root of negative number is not real!");
                } else {
                    result = squareRoot(num1);
                    displaySquareRootResult(num1, result);
                }
                break;

            case 7: // Percentage
                calculatePercentage();
                break;

            case 8: // Factorial
                int n = (int) getNumberInput("Enter non-negative integer: ");
                if (n < 0) {
                    System.out.println("Error: Factorial is not defined for negative numbers!");
                } else if (n > 20) {
                    System.out.println("Warning: Large factorials may cause overflow!");
                } else {
                    long factorial = calculateFactorial(n);
                    displayFactorialResult(n, factorial);
                }
                break;

            case 9: // Modulo
                num1 = getNumberInput("Enter dividend: ");
                num2 = getNumberInput("Enter divisor: ");
                if (num2 == 0) {
                    System.out.println("Error: Modulo by zero is undefined!");
                } else {
                    result = modulo(num1, num2);
                    displayResult(num1, num2, result, "mod");
                }
                break;

            case 10: // Scientific Calculator
                scientificCalculator();
                break;
        }
    }

    /**
     * Addition function
     * @param a First number
     * @param b Second number
     * @return Sum of a and b
     */
    private static double add(double a, double b) {
        return a + b;
    }

    /**
     * Subtraction function
     * @param a First number
     * @param b Second number
     * @return Difference of a and b
     */
    private static double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Multiplication function
     * @param a First number
     * @param b Second number
     * @return Product of a and b
     */
    private static double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Division function
     * @param a Dividend
     * @param b Divisor
     * @return Quotient of a divided by b
     */
    private static double divide(double a, double b) {
        return a / b;
    }

    /**
     * Power function
     * @param base Base number
     * @param exponent Exponent
     * @return base raised to the power of exponent
     */
    private static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    /**
     * Square root function
     * @param number Number to find square root of
     * @return Square root of number
     */
    private static double squareRoot(double number) {
        return Math.sqrt(number);
    }

    /**
     * Modulo function
     * @param a Dividend
     * @param b Divisor
     * @return Remainder of a divided by b
     */
    private static double modulo(double a, double b) {
        return a % b;
    }

    /**
     * Factorial function
     * @param n Number to calculate factorial for
     * @return Factorial of n
     */
    private static long calculateFactorial(int n) {
        if (n <= 1) return 1;
        return n * calculateFactorial(n - 1);
    }

    /**
     * Display calculation result
     * @param num1 First number
     * @param num2 Second number
     * @param result Calculation result
     * @param operation Operation symbol
     */
    private static void displayResult(double num1, double num2, double result, String operation) {
        System.out.println("\n=== Result ===");
        System.out.println(df.format(num1) + " " + operation + " " + df.format(num2) + " = " + df.format(result));
    }

    /**
     * Display power calculation result
     * @param base Base number
     * @param exponent Exponent
     * @param result Result
     */
    private static void displayPowerResult(double base, double exponent, double result) {
        System.out.println("\n=== Result ===");
        System.out.println(df.format(base) + "^" + df.format(exponent) + " = " + df.format(result));

        // Additional info for common powers
        if (exponent == 2) {
            System.out.println("(Square of " + df.format(base) + ")");
        } else if (exponent == 3) {
            System.out.println("(Cube of " + df.format(base) + ")");
        } else if (exponent == 0.5) {
            System.out.println("(Square root of " + df.format(base) + ")");
        }
    }

    /**
     * Display square root result
     * @param number Original number
     * @param result Square root
     */
    private static void displaySquareRootResult(double number, double result) {
        System.out.println("\n=== Result ===");
        System.out.println("√" + df.format(number) + " = " + df.format(result));

        // Verify result
        double verification = result * result;
        System.out.println("Verification: " + df.format(result) + "² = " + df.format(verification));
    }

    /**
     * Display factorial result
     * @param n Original number
     * @param factorial Factorial result
     */
    private static void displayFactorialResult(int n, long factorial) {
        System.out.println("\n=== Result ===");
        System.out.println(n + "! = " + factorial);

        // Show expansion for small numbers
        if (n <= 5) {
            System.out.print("Expansion: ");
            for (int i = n; i > 0; i--) {
                System.out.print(i);
                if (i > 1) System.out.print(" × ");
            }
            System.out.println(" = " + factorial);
        }
    }

    /**
     * Show additional division information
     * @param dividend Dividend
     * @param divisor Divisor
     * @param quotient Quotient
     */
    private static void showDivisionInfo(double dividend, double divisor, double quotient) {
        System.out.println("\nAdditional Information:");

        // Show remainder for integer division
        if (dividend == Math.floor(dividend) && divisor == Math.floor(divisor)) {
            double remainder = dividend % divisor;
            System.out.println("Integer division: " + (int)dividend + " ÷ " + (int)divisor + 
                             " = " + (int)quotient + " remainder " + (int)remainder);
        }

        // Show reciprocal
        if (dividend != 0) {
            double reciprocal = divisor / dividend;
            System.out.println("Reciprocal: " + df.format(divisor) + " ÷ " + df.format(dividend) + 
                             " = " + df.format(reciprocal));
        }
    }

    /**
     * Calculate percentage operations
     */
    private static void calculatePercentage() {
        System.out.println("\n=== Percentage Calculator ===");
        System.out.println("1. What is X% of Y?");
        System.out.println("2. X is what percent of Y?");
        System.out.println("3. What is the percentage increase/decrease from X to Y?");

        int choice = (int) getNumberInput("Choose calculation type (1-3): ");

        switch (choice) {
            case 1:
                double percent = getNumberInput("Enter percentage: ");
                double total = getNumberInput("Enter total value: ");
                double result1 = (percent / 100) * total;
                System.out.println("\nResult: " + df.format(percent) + "% of " + df.format(total) + 
                                 " = " + df.format(result1));
                break;

            case 2:
                double part = getNumberInput("Enter part value: ");
                double whole = getNumberInput("Enter whole value: ");
                if (whole == 0) {
                    System.out.println("Error: Cannot divide by zero!");
                } else {
                    double result2 = (part / whole) * 100;
                    System.out.println("\nResult: " + df.format(part) + " is " + df.format(result2) + 
                                     "% of " + df.format(whole));
                }
                break;

            case 3:
                double oldValue = getNumberInput("Enter original value: ");
                double newValue = getNumberInput("Enter new value: ");
                if (oldValue == 0) {
                    System.out.println("Error: Original value cannot be zero!");
                } else {
                    double change = ((newValue - oldValue) / oldValue) * 100;
                    String changeType = change >= 0 ? "increase" : "decrease";
                    System.out.println("\nResult: " + df.format(Math.abs(change)) + "% " + changeType +
                                     " from " + df.format(oldValue) + " to " + df.format(newValue));
                }
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }

    /**
     * Scientific calculator with advanced functions
     */
    private static void scientificCalculator() {
        System.out.println("\n=== Scientific Calculator ===");
        System.out.println("1. Sine (sin)");
        System.out.println("2. Cosine (cos)");
        System.out.println("3. Tangent (tan)");
        System.out.println("4. Natural Logarithm (ln)");
        System.out.println("5. Logarithm Base 10 (log)");
        System.out.println("6. Exponential (e^x)");

        int choice = (int) getNumberInput("Choose function (1-6): ");
        double input = getNumberInput("Enter value: ");
        double result;
        String function;

        switch (choice) {
            case 1:
                result = Math.sin(Math.toRadians(input));
                function = "sin(" + df.format(input) + "°)";
                break;
            case 2:
                result = Math.cos(Math.toRadians(input));
                function = "cos(" + df.format(input) + "°)";
                break;
            case 3:
                result = Math.tan(Math.toRadians(input));
                function = "tan(" + df.format(input) + "°)";
                break;
            case 4:
                if (input <= 0) {
                    System.out.println("Error: Logarithm undefined for non-positive numbers!");
                    return;
                }
                result = Math.log(input);
                function = "ln(" + df.format(input) + ")";
                break;
            case 5:
                if (input <= 0) {
                    System.out.println("Error: Logarithm undefined for non-positive numbers!");
                    return;
                }
                result = Math.log10(input);
                function = "log₁₀(" + df.format(input) + ")";
                break;
            case 6:
                result = Math.exp(input);
                function = "e^" + df.format(input);
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        System.out.println("\n=== Result ===");
        System.out.println(function + " = " + df.format(result));
    }

    /**
     * Ask user if they want to continue calculating
     * @return true if user wants to continue, false otherwise
     */
    private static boolean askToContinue() {
        System.out.print("\nDo you want to perform another calculation? (y/n): ");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("y") || response.equals("yes");
    }
}