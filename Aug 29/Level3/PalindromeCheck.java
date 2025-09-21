package Assignment5.Level3;

import java.util.Scanner;

public class PalindromeCheck {
    static boolean isPalindrome(String str) {
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) 
            return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = sc.nextLine();

        if (isPalindrome(str))
            System.out.println(str + " is a palindrome.");
        else
            System.out.println(str + " is NOT a palindrome.");
    }
}

