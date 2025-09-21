package Assignment7.ProblemStatement;

import java.util.Scanner;

public class MostFrequentChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.println("Most Frequent Character: " + mostFrequent(str));
    }

    public static char mostFrequent(String str) {
        int[] freq = new int[256];
        for (char ch : str.toCharArray()) freq[ch]++;
        int max = 0;
        char result = ' ';
        for (int i = 0; i < 256; i++) {
            if (freq[i] > max) {
                max = freq[i];
                result = (char)i;
            }
        }
        return result;
    }
}
