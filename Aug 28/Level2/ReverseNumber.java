package Assignment4.Level2;

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        long number = sc.nextLong();

        int[] digits = new int[20];
        int count = 0;

        while (number > 0) {
            digits[count++] = (int)(number % 10);
            number /= 10;
        }

        System.out.print("Reversed number: ");
        for (int i = 0; i < count; i++) {
            System.out.print(digits[i]+" ");
        }
        System.out.println();
    }
}

