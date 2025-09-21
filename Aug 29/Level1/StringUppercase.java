package Assignment5.Level1;

import java.util.Scanner;

public class StringUppercase {
     public static String toUpperManual(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char)(ch - 32); 
            }
            result += ch;
        }
        return result;
    }

    public static boolean compareStrings(String a, String b) {
        return a.equals(b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        String manual = toUpperManual(input);
        String builtIn = input.toUpperCase();

        System.out.println("Manual Upper: " + manual);
        System.out.println("Built-in Upper: " + builtIn);
        System.out.println("Are both equal " + compareStrings(manual, builtIn));
    }
}
