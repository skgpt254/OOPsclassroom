package Assignment6.Level1;

import java.util.Scanner;

public class TriangularPark {
    static double calculateRounds(double a, double b, double c) {
        double perimeter = a + b + c;
        double distance = 5000; // in meters
        return distance / perimeter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter side1: ");
        double a = sc.nextDouble();
        System.out.print("Enter side2: ");
        double b = sc.nextDouble();
        System.out.print("Enter side3: ");
        double c = sc.nextDouble();

        System.out.println("Rounds to complete 5km: " + calculateRounds(a, b, c));
    }
}

