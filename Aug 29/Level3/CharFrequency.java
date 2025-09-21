package Assignment5.Level3;

import java.util.Scanner;

public class CharFrequency {
    static void findFrequency(String str) {
        int[] freq = new int[256];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }
        
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0)
                System.out.println((char) i + " : " + freq[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = sc.nextLine();

        findFrequency(str);
    }
}

