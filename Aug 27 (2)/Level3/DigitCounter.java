package Assignment3.Level3;

import java.util.Scanner;

public class DigitCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        int number = sc.nextInt();

        int count = 0;
        int temp = number;

        if (temp == 0) {
            count = 1;
        } else {
            while (temp > 0) {
                temp /= 10;
                count++;
            }
        }

        System.out.println("Number of digits: " + count);
    }
}

