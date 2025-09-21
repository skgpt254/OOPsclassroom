package Assignment2.Level1;

import java.util.Scanner;

public class DistanceConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double km;
        km = sc.nextDouble();

        double miles = km / 1.6;
        System.out.println(miles);
    }
}

