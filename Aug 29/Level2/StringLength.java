package Assignment5.Level2;

import java.util.Scanner;

public class StringLength {
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } 
        catch (Exception e) {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();
        System.out.println("Built-in length: " + input.length());
        System.out.println("Custom length: " + findLength(input));
    }
}

