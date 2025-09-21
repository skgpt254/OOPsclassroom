package Assignment5.Level1;

import java.util.Scanner;

public class StringCompare {
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) 
        return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) 
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        String str1 = sc.nextLine();
       
        String str2 = sc.nextLine();

        boolean manualCompare = compareStrings(str1, str2);
        boolean equalsMethod = str1.equals(str2);

       System.out.println(manualCompare);
       System.out.println(equalsMethod);
    }
}

