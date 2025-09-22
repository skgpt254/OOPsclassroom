import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * Problem 4: Date Comparison
 * Compare two dates using isBefore(), isAfter(), and isEqual() methods
 */
public class DateComparison {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Get first date from user
            LocalDate date1 = getDateInput(scanner, "Enter the first date (yyyy-MM-dd): ");

            // Get second date from user
            LocalDate date2 = getDateInput(scanner, "Enter the second date (yyyy-MM-dd): ");

            // Display the dates
            System.out.println("\nDate Comparison Results:");
            System.out.println("========================");
            System.out.println("First date:  " + date1.format(FORMATTER));
            System.out.println("Second date: " + date2.format(FORMATTER));

            // Perform comparisons
            performComparisons(date1, date2);

            // Calculate differences
            calculateDifferences(date1, date2);

            // Additional comparison examples
            demonstrateAdditionalComparisons();

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    /**
     * Get date input from user with validation
     */
    private static LocalDate getDateInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                return LocalDate.parse(input, FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("Error: Invalid date format. Please use yyyy-MM-dd format.");
            }
        }
    }

    /**
     * Perform basic date comparisons
     */
    private static void performComparisons(LocalDate date1, LocalDate date2) {
        System.out.println("\nComparison Results:");

        if (date1.isBefore(date2)) {
            System.out.println("✓ First date is BEFORE second date");
        } else if (date1.isAfter(date2)) {
            System.out.println("✓ First date is AFTER second date");
        } else if (date1.isEqual(date2)) {
            System.out.println("✓ Both dates are EQUAL");
        }

        // Additional comparison details
        System.out.println("\nDetailed Comparison:");
        System.out.println("date1.isBefore(date2): " + date1.isBefore(date2));
        System.out.println("date1.isAfter(date2): " + date1.isAfter(date2));
        System.out.println("date1.isEqual(date2): " + date1.isEqual(date2));
        System.out.println("date1.compareTo(date2): " + date1.compareTo(date2));

        // Explain compareTo result
        int compareResult = date1.compareTo(date2);
        if (compareResult < 0) {
            System.out.println("(Negative value means first date is earlier)");
        } else if (compareResult > 0) {
            System.out.println("(Positive value means first date is later)");
        } else {
            System.out.println("(Zero means both dates are equal)");
        }
    }

    /**
     * Calculate various differences between dates
     */
    private static void calculateDifferences(LocalDate date1, LocalDate date2) {
        System.out.println("\nDate Differences:");

        long daysDifference = ChronoUnit.DAYS.between(date1, date2);
        long weeksDifference = ChronoUnit.WEEKS.between(date1, date2);
        long monthsDifference = ChronoUnit.MONTHS.between(date1, date2);
        long yearsDifference = ChronoUnit.YEARS.between(date1, date2);

        System.out.println("Days between dates: " + Math.abs(daysDifference));
        System.out.println("Weeks between dates: " + Math.abs(weeksDifference));
        System.out.println("Months between dates: " + Math.abs(monthsDifference));
        System.out.println("Years between dates: " + Math.abs(yearsDifference));

        if (daysDifference > 0) {
            System.out.println("Second date is " + daysDifference + " days after first date");
        } else if (daysDifference < 0) {
            System.out.println("Second date is " + Math.abs(daysDifference) + " days before first date");
        } else {
            System.out.println("Both dates are the same");
        }
    }

    /**
     * Demonstrate additional comparison scenarios
     */
    private static void demonstrateAdditionalComparisons() {
        System.out.println("\nAdditional Comparison Examples:");
        System.out.println("===============================");

        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        LocalDate tomorrow = today.plusDays(1);
        LocalDate nextWeek = today.plusWeeks(1);

        System.out.println("Today: " + today.format(FORMATTER));
        System.out.println("Yesterday: " + yesterday.format(FORMATTER));
        System.out.println("Tomorrow: " + tomorrow.format(FORMATTER));
        System.out.println("Next week: " + nextWeek.format(FORMATTER));

        System.out.println("\nComparisons with today:");
        System.out.println("Yesterday is before today: " + yesterday.isBefore(today));
        System.out.println("Tomorrow is after today: " + tomorrow.isAfter(today));
        System.out.println("Today equals today: " + today.isEqual(today));
        System.out.println("Next week is after today: " + nextWeek.isAfter(today));
    }
}