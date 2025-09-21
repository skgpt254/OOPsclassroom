package Assignment7.ProblemStatement;

import java.util.Scanner;

public class CompareStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String 1: ");
        String s1 = sc.nextLine();
        System.out.print("Enter String 2: ");
        String s2 = sc.nextLine();
        compareStrings(s1, s2);
    }

    public static void compareStrings(String s1, String s2) {
        int i = 0;
        while (i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) != s2.charAt(i)) break;
            i++;
        }
        if (i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) < s2.charAt(i)) System.out.println(s1 + " comes before " + s2);
            else System.out.println(s2 + " comes before " + s1);
        } else if (s1.length() < s2.length()) {
            System.out.println(s1 + " comes before " + s2);
        } else if (s1.length() > s2.length()) {
            System.out.println(s2 + " comes before " + s1);
        } else {
            System.out.println("Both strings are equal.");
        }
    }
}

