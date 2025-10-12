import java.util.*;
import java.text.*;

interface DateFormatter {
    static String formatDate(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }
}

class DateFormatDemo {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            String pattern = s.nextLine().trim();
            if (pattern.isEmpty()) {
                pattern = "yyyy-MM-dd HH:mm:ss";
            }
            Date now = new Date();
            try {
                System.out.println("Formatted Date: " + DateFormatter.formatDate(now, pattern));
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid date pattern: " + pattern);
            }
        }
    }
}
