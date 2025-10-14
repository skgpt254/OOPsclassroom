import java.util.*;
import java.util.function.*;

class Alert {
    String type;
    String message;
    Alert(String t, String m) { type = t; message = m; }
    public String toString() { return type + ": " + message; }
}

public class notFilter {
    public static void main(String[] args) {
        List<Alert> alerts = Arrays.asList(
            new Alert("CRITICAL", "Heart rate abnormal"),
            new Alert("INFO", "Daily check complete"),
            new Alert("WARNING", "Low battery in monitor")
        );

        Predicate<Alert> criticalOnly = a -> a.type.equals("CRITICAL");
        Predicate<Alert> excludeInfo = a -> !a.type.equals("INFO");

        alerts.stream()
              .filter(criticalOnly.and(excludeInfo))
              .forEach(System.out::println);
    }
}
