import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Problem 3: Date Formatting
 * Display current date in three different formats
 */
public class DateFormatting {
    public static void main(String[] args) {
        // Get current date
        LocalDate currentDate = LocalDate.now();

        // Define formatters for different patterns
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy", Locale.ENGLISH);

        // Additional interesting formats
        DateTimeFormatter format4 = DateTimeFormatter.ofPattern("MMMM dd, yyyy", Locale.ENGLISH);
        DateTimeFormatter format5 = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);

        // Display formatted dates
        System.out.println("Current Date in Different Formats:");
        System.out.println("=================================");
        System.out.println("Format 1 (dd/MM/yyyy): " + currentDate.format(format1));
        System.out.println("Format 2 (yyyy-MM-dd): " + currentDate.format(format2));
        System.out.println("Format 3 (EEE, MMM dd, yyyy): " + currentDate.format(format3));

        System.out.println("\nAdditional Formats:");
        System.out.println("Full Month (MMMM dd, yyyy): " + currentDate.format(format4));
        System.out.println("Short Month (dd-MMM-yyyy): " + currentDate.format(format5));

        // Display day information
        System.out.println("\nDate Information:");
        System.out.println("Day of week: " + currentDate.getDayOfWeek());
        System.out.println("Day of month: " + currentDate.getDayOfMonth());
        System.out.println("Day of year: " + currentDate.getDayOfYear());
        System.out.println("Month: " + currentDate.getMonth());
        System.out.println("Year: " + currentDate.getYear());

        // Demonstrate parsing capabilities
        System.out.println("\nDemonstrating Date Parsing:");
        String dateString1 = "25/12/2023";
        String dateString2 = "2023-12-25";
        String dateString3 = "Mon, Dec 25, 2023";

        try {
            LocalDate parsed1 = LocalDate.parse(dateString1, format1);
            LocalDate parsed2 = LocalDate.parse(dateString2, format2);
            LocalDate parsed3 = LocalDate.parse(dateString3, format3);

            System.out.println("Parsed '" + dateString1 + "' as: " + parsed1);
            System.out.println("Parsed '" + dateString2 + "' as: " + parsed2);
            System.out.println("Parsed '" + dateString3 + "' as: " + parsed3);

        } catch (Exception e) {
            System.out.println("Error parsing date: " + e.getMessage());
        }
    }
}