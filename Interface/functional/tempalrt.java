import java.util.*;
import java.util.function.Predicate;

class tempalrt {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try {
            System.out.print("Enter temperature: ");
            if (!s.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a numeric temperature.");
                return;
            }
            double temp = s.nextDouble();
            Predicate<Double> highTemp = t -> t > 40.0;
            if (highTemp.test(temp))
                System.out.println("Alert: High Temperature!");
            else
                System.out.println("Temperature Normal.");
        } finally {
            s.close();
        }
    }
}
