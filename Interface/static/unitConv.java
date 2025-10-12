import java.util.*;

interface UnitConverter {
    static double kmToMiles(double km) { return km * 0.621371; }
    static double kgToLbs(double kg) { return kg * 2.20462; }
}

class UnitConv {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            // Expect two doubles: km then kg
            if (!s.hasNextDouble()) {
                System.err.println("Missing or invalid input for kilometers (km).");
                return;
            }
            double km = s.nextDouble();

            if (!s.hasNextDouble()) {
                System.err.println("Missing or invalid input for kilograms (kg).");
                return;
            }
            double kg = s.nextDouble();

            System.out.printf("Miles: %.6f%n", UnitConverter.kmToMiles(km));
            System.out.printf("Pounds: %.6f%n", UnitConverter.kgToLbs(kg));
        }
    }
}
