import java.util.Scanner;

/**
 * Level 2 Problem 8: Temperature Converter
 * Demonstrates modular programming with separate functions for different conversions
 */
public class TemperatureConverter {
    private static Scanner scanner = new Scanner(System.in);

    // Temperature scale constants
    private static final String CELSIUS = "C";
    private static final String FAHRENHEIT = "F";
    private static final String KELVIN = "K";
    private static final String RANKINE = "R";

    public static void main(String[] args) {
        System.out.println("=== Temperature Converter ===");

        // Display menu and get user choice
        displayMenu();
        int choice = getUserChoice();

        // Process conversion based on choice
        processConversion(choice);

        // Demonstrate all conversions with a sample temperature
        demonstrateAllConversions();

        scanner.close();
    }

    /**
     * Display conversion menu to user
     */
    private static void displayMenu() {
        System.out.println("\nSelect conversion type:");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("3. Celsius to Kelvin");
        System.out.println("4. Kelvin to Celsius");
        System.out.println("5. Fahrenheit to Kelvin");
        System.out.println("6. Kelvin to Fahrenheit");
        System.out.println("7. Convert to all scales");
        System.out.println("8. Temperature comparison");
    }

    /**
     * Get user's menu choice with validation
     * @return Valid menu choice (1-8)
     */
    private static int getUserChoice() {
        while (true) {
            try {
                System.out.print("\nEnter your choice (1-8): ");
                int choice = Integer.parseInt(scanner.nextLine().trim());

                if (choice >= 1 && choice <= 8) {
                    return choice;
                }

                System.out.println("Please enter a number between 1 and 8.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }
    }

    /**
     * Get temperature value from user
     * @param scale Temperature scale
     * @return Temperature value
     */
    private static double getTemperatureInput(String scale) {
        while (true) {
            try {
                System.out.print("Enter temperature in " + getScaleName(scale) + ": ");
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }
    }

    /**
     * Process temperature conversion based on user choice
     * @param choice User's menu choice
     */
    private static void processConversion(int choice) {
        double inputTemp;
        double result;
        String inputScale, outputScale;

        switch (choice) {
            case 1:
                inputTemp = getTemperatureInput(CELSIUS);
                result = celsiusToFahrenheit(inputTemp);
                displayConversionResult(inputTemp, CELSIUS, result, FAHRENHEIT);
                break;

            case 2:
                inputTemp = getTemperatureInput(FAHRENHEIT);
                result = fahrenheitToCelsius(inputTemp);
                displayConversionResult(inputTemp, FAHRENHEIT, result, CELSIUS);
                break;

            case 3:
                inputTemp = getTemperatureInput(CELSIUS);
                result = celsiusToKelvin(inputTemp);
                displayConversionResult(inputTemp, CELSIUS, result, KELVIN);
                break;

            case 4:
                inputTemp = getTemperatureInput(KELVIN);
                result = kelvinToCelsius(inputTemp);
                displayConversionResult(inputTemp, KELVIN, result, CELSIUS);
                break;

            case 5:
                inputTemp = getTemperatureInput(FAHRENHEIT);
                result = fahrenheitToKelvin(inputTemp);
                displayConversionResult(inputTemp, FAHRENHEIT, result, KELVIN);
                break;

            case 6:
                inputTemp = getTemperatureInput(KELVIN);
                result = kelvinToFahrenheit(inputTemp);
                displayConversionResult(inputTemp, KELVIN, result, FAHRENHEIT);
                break;

            case 7:
                convertToAllScales();
                break;

            case 8:
                compareTemperatures();
                break;
        }
    }

    /**
     * Convert Celsius to Fahrenheit
     * @param celsius Temperature in Celsius
     * @return Temperature in Fahrenheit
     */
    private static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32.0;
    }

    /**
     * Convert Fahrenheit to Celsius
     * @param fahrenheit Temperature in Fahrenheit
     * @return Temperature in Celsius
     */
    private static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }

    /**
     * Convert Celsius to Kelvin
     * @param celsius Temperature in Celsius
     * @return Temperature in Kelvin
     */
    private static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    /**
     * Convert Kelvin to Celsius
     * @param kelvin Temperature in Kelvin
     * @return Temperature in Celsius
     */
    private static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    /**
     * Convert Fahrenheit to Kelvin
     * @param fahrenheit Temperature in Fahrenheit
     * @return Temperature in Kelvin
     */
    private static double fahrenheitToKelvin(double fahrenheit) {
        double celsius = fahrenheitToCelsius(fahrenheit);
        return celsiusToKelvin(celsius);
    }

    /**
     * Convert Kelvin to Fahrenheit
     * @param kelvin Temperature in Kelvin
     * @return Temperature in Fahrenheit
     */
    private static double kelvinToFahrenheit(double kelvin) {
        double celsius = kelvinToCelsius(kelvin);
        return celsiusToFahrenheit(celsius);
    }

    /**
     * Convert Celsius to Rankine
     * @param celsius Temperature in Celsius
     * @return Temperature in Rankine
     */
    private static double celsiusToRankine(double celsius) {
        return (celsius + 273.15) * 9.0 / 5.0;
    }

    /**
     * Convert Rankine to Celsius
     * @param rankine Temperature in Rankine
     * @return Temperature in Celsius
     */
    private static double rankineToCelsius(double rankine) {
        return (rankine * 5.0 / 9.0) - 273.15;
    }

    /**
     * Get full scale name from abbreviation
     * @param scale Scale abbreviation
     * @return Full scale name
     */
    private static String getScaleName(String scale) {
        switch (scale) {
            case CELSIUS: return "Celsius (°C)";
            case FAHRENHEIT: return "Fahrenheit (°F)";
            case KELVIN: return "Kelvin (K)";
            case RANKINE: return "Rankine (°R)";
            default: return "Unknown";
        }
    }

    /**
     * Display conversion result
     * @param inputTemp Input temperature
     * @param inputScale Input scale
     * @param outputTemp Output temperature
     * @param outputScale Output scale
     */
    private static void displayConversionResult(double inputTemp, String inputScale, 
                                              double outputTemp, String outputScale) {
        System.out.println("\n=== Conversion Result ===");
        System.out.printf("%.2f %s = %.2f %s%n", 
                         inputTemp, getScaleSymbol(inputScale), 
                         outputTemp, getScaleSymbol(outputScale));

        // Add contextual information
        addContextualInfo(outputTemp, outputScale);
    }

    /**
     * Get scale symbol
     * @param scale Scale abbreviation
     * @return Scale symbol
     */
    private static String getScaleSymbol(String scale) {
        switch (scale) {
            case CELSIUS: return "°C";
            case FAHRENHEIT: return "°F";
            case KELVIN: return "K";
            case RANKINE: return "°R";
            default: return "";
        }
    }

    /**
     * Add contextual information about temperature
     * @param temp Temperature value
     * @param scale Temperature scale
     */
    private static void addContextualInfo(double temp, String scale) {
        System.out.println("\nContextual Information:");

        // Convert to Celsius for reference
        double celsius = temp;
        if (scale.equals(FAHRENHEIT)) {
            celsius = fahrenheitToCelsius(temp);
        } else if (scale.equals(KELVIN)) {
            celsius = kelvinToCelsius(temp);
        }

        // Provide context
        if (celsius < -273.15) {
            System.out.println("⚠️  Below absolute zero - physically impossible!");
        } else if (celsius < -40) {
            System.out.println("🥶 Extremely cold - Arctic conditions");
        } else if (celsius < 0) {
            System.out.println("❄️  Below freezing point of water");
        } else if (celsius == 0) {
            System.out.println("🧊 Freezing point of water");
        } else if (celsius < 20) {
            System.out.println("🌡️  Cool temperature");
        } else if (celsius < 30) {
            System.out.println("🌤️  Comfortable room temperature");
        } else if (celsius < 40) {
            System.out.println("☀️  Warm temperature");
        } else if (celsius < 50) {
            System.out.println("🔥 Very hot");
        } else if (celsius == 100) {
            System.out.println("💨 Boiling point of water");
        } else if (celsius > 100) {
            System.out.println("🔥 Above boiling point of water");
        }
    }

    /**
     * Convert input temperature to all scales
     */
    private static void convertToAllScales() {
        System.out.print("\nEnter temperature scale (C/F/K): ");
        String inputScale = scanner.nextLine().trim().toUpperCase();

        if (!inputScale.equals(CELSIUS) && !inputScale.equals(FAHRENHEIT) && !inputScale.equals(KELVIN)) {
            System.out.println("Invalid scale. Using Celsius.");
            inputScale = CELSIUS;
        }

        double inputTemp = getTemperatureInput(inputScale);

        // Convert to all scales
        double celsius, fahrenheit, kelvin, rankine;

        if (inputScale.equals(CELSIUS)) {
            celsius = inputTemp;
            fahrenheit = celsiusToFahrenheit(celsius);
            kelvin = celsiusToKelvin(celsius);
            rankine = celsiusToRankine(celsius);
        } else if (inputScale.equals(FAHRENHEIT)) {
            fahrenheit = inputTemp;
            celsius = fahrenheitToCelsius(fahrenheit);
            kelvin = celsiusToKelvin(celsius);
            rankine = celsiusToRankine(celsius);
        } else {
            kelvin = inputTemp;
            celsius = kelvinToCelsius(kelvin);
            fahrenheit = celsiusToFahrenheit(celsius);
            rankine = celsiusToRankine(celsius);
        }

        System.out.println("\n=== Temperature in All Scales ===");
        System.out.printf("Celsius:    %.2f °C%n", celsius);
        System.out.printf("Fahrenheit: %.2f °F%n", fahrenheit);
        System.out.printf("Kelvin:     %.2f K%n", kelvin);
        System.out.printf("Rankine:    %.2f °R%n", rankine);

        addContextualInfo(celsius, CELSIUS);
    }

    /**
     * Compare multiple temperatures
     */
    private static void compareTemperatures() {
        System.out.println("\n=== Temperature Comparison ===");

        // Get first temperature
        System.out.println("Enter first temperature:");
        System.out.print("Scale (C/F/K): ");
        String scale1 = scanner.nextLine().trim().toUpperCase();
        double temp1 = getTemperatureInput(scale1);

        // Get second temperature
        System.out.println("\nEnter second temperature:");
        System.out.print("Scale (C/F/K): ");
        String scale2 = scanner.nextLine().trim().toUpperCase();
        double temp2 = getTemperatureInput(scale2);

        // Convert both to Celsius for comparison
        double celsius1 = convertToCelsius(temp1, scale1);
        double celsius2 = convertToCelsius(temp2, scale2);

        System.out.println("\n=== Comparison Results ===");
        System.out.printf("Temperature 1: %.2f %s (%.2f °C)%n", temp1, getScaleSymbol(scale1), celsius1);
        System.out.printf("Temperature 2: %.2f %s (%.2f °C)%n", temp2, getScaleSymbol(scale2), celsius2);

        double difference = Math.abs(celsius1 - celsius2);

        if (celsius1 > celsius2) {
            System.out.printf("Temperature 1 is %.2f °C higher%n", difference);
        } else if (celsius2 > celsius1) {
            System.out.printf("Temperature 2 is %.2f °C higher%n", difference);
        } else {
            System.out.println("Both temperatures are equal");
        }
    }

    /**
     * Convert any temperature to Celsius
     * @param temp Temperature value
     * @param scale Temperature scale
     * @return Temperature in Celsius
     */
    private static double convertToCelsius(double temp, String scale) {
        switch (scale) {
            case FAHRENHEIT:
                return fahrenheitToCelsius(temp);
            case KELVIN:
                return kelvinToCelsius(temp);
            case CELSIUS:
            default:
                return temp;
        }
    }

    /**
     * Demonstrate all conversions with sample temperatures
     */
    private static void demonstrateAllConversions() {
        System.out.println("\n=== Sample Conversions ===");

        double[] sampleTemps = {0, 25, 100, -40, 273.15};
        String[] descriptions = {"Freezing point", "Room temperature", "Boiling point", 
                               "F=C point", "Absolute zero in K"};

        for (int i = 0; i < sampleTemps.length; i++) {
            double celsius = sampleTemps[i];
            if (i == 4) celsius = kelvinToCelsius(sampleTemps[i]); // Last one is in Kelvin

            System.out.printf("\n%s:%n", descriptions[i]);
            System.out.printf("  Celsius:    %.2f °C%n", celsius);
            System.out.printf("  Fahrenheit: %.2f °F%n", celsiusToFahrenheit(celsius));
            System.out.printf("  Kelvin:     %.2f K%n", celsiusToKelvin(celsius));
        }
    }
}