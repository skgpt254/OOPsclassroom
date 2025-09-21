package Assignment3.Level2;

import java.util.Scanner;

public class MultiplesFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        if (number > 0 && number < 100) {
            for (int i = 1; i < 100; i++) {
                if (i % number == 0)
                    System.out.println(i);
            }
        } else {
            System.out.println("Invalid input.");
        }
    }
}

