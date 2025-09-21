package Assignment2.Level1;

import java.util.Scanner;

public class SquareSide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double perimeter = sc.nextDouble();

        double side = perimeter / 4;

        System.out.println(side);
    }
}

