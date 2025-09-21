package Assignment4.Level1;

import java.util.Scanner;

public class NumberChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            
            numbers[i] = sc.nextInt();
        }

        for (int num : numbers) {
            if (num > 0) {
                if (num % 2 == 0) {
                    System.out.println(num + " is Positive and Even");
                } else {
                    System.out.println(num + " is Positive and Odd");
                }
            } 
            else if (num < 0) {
                System.out.println(num + " is Negative");
            } 
            else {
                System.out.println(num + " is Zero");
            }
        }

        // Compare first and last
        if (numbers[0] == numbers[4]) {
            System.out.println("First and last elements are equal.");
        } else if (numbers[0] > numbers[4]) {
            System.out.println("First element is greater than the last.");
        } else {
            System.out.println("First element is less than the last.");
        }
    }
}

