package Assignment2.Level2;

import java.util.Scanner;

public class feetToYardandMiles {
       public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double feet = sc.nextDouble();

        double yards = feet / 3;
        double miles = yards / 1760;

        System.out.println(miles);
    }
}
