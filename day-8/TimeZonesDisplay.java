import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Problem 1: Time Zones and ZonedDateTime
 * Display current time in different time zones: GMT, IST, PST
 */
public class TimeZonesDisplay {
    public static void main(String[] args) {
        // Get current time
        ZonedDateTime now = ZonedDateTime.now();

        // Define time zones
        ZoneId gmtZone = ZoneId.of("GMT");
        ZoneId istZone = ZoneId.of("Asia/Kolkata"); // Indian Standard Time
        ZoneId pstZone = ZoneId.of("America/Los_Angeles"); // Pacific Standard Time

        // Convert to different time zones
        ZonedDateTime gmtTime = now.withZoneSameInstant(gmtZone);
        ZonedDateTime istTime = now.withZoneSameInstant(istZone);
        ZonedDateTime pstTime = now.withZoneSameInstant(pstZone);

        // Format for display
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");

        // Display results
        System.out.println("Current Time in Different Time Zones:");
        System.out.println("====================================");
        System.out.println("GMT (Greenwich Mean Time): " + gmtTime.format(formatter));
        System.out.println("IST (Indian Standard Time): " + istTime.format(formatter));
        System.out.println("PST (Pacific Standard Time): " + pstTime.format(formatter));

        // Additional information
        System.out.println("\nTime Zone Information:");
        System.out.println("GMT Offset: " + gmtTime.getOffset());
        System.out.println("IST Offset: " + istTime.getOffset());
        System.out.println("PST Offset: " + pstTime.getOffset());
    }
}