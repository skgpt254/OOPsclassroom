import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Problem 2: Date Arithmetic
 * Takes a date input and performs various arithmetic operations
 */
public class DateArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            // Get date input from user
            System.out.print("Enter a date (yyyy-MM-dd format): ");
            String inputDate = scanner.nextLine();

            // Parse the input date
            LocalDate date = LocalDate.parse(inputDate, formatter);
            System.out.println("Original date: " + date.format(formatter));

            // Step 1: Add 7 days, 1 month, and 2 years
            LocalDate step1 = date.plusDays(7)
                                 .plusMonths(1)
                                 .plusYears(2);
            System.out.println("After adding 7 days, 1 month, and 2 years: " + step1.format(formatter));

            // Step 2: Subtract 3 weeks from the result
            LocalDate finalResult = step1.minusWeeks(3);
            System.out.println("After subtracting 3 weeks: " + finalResult.format(formatter));

            // Display step-by-step breakdown
            System.out.println("\nStep-by-step breakdown:");
            System.out.println("1. Original date: " + date.format(formatter));
            System.out.println("2. Add 7 days: " + date.plusDays(7).format(formatter));
            System.out.println("3. Add 1 month: " + date.plusDays(7).plusMonths(1).format(formatter));
            System.out.println("4. Add 2 years: " + step1.format(formatter));
            System.out.println("5. Subtract 3 weeks: " + finalResult.format(formatter));

            // Calculate total difference
            long daysDifference = finalResult.toEpochDay() - date.toEpochDay();
            System.out.println("\nTotal difference from original: " + daysDifference + " days");

        } catch (Exception e) {
            System.out.println("Error: Invalid date format. Please use yyyy-MM-dd format.");
        } finally {
            scanner.close();
        }
    }
}