package Assignment5.Level3;

import java.util.Scanner;

public class FirstNonRepeating {
    static char firstNonRepeatingChar(String str) {
        int[] freq = new int[256];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i)] == 1)
                return str.charAt(i);
        }
        return '\0';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = sc.nextLine();

        char ch = firstNonRepeatingChar(str);
        if (ch != '\0')
            System.out.println("First non-repeating character: " + ch);
        else
            System.out.println("No unique character found");
    }
}

