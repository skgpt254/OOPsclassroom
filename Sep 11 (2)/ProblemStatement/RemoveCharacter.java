package Assignment7.ProblemStatement;

import java.util.Scanner;

public class RemoveCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.print("Enter character to remove: ");
        char ch = sc.next().charAt(0);
        System.out.println("Modified String: " + removeChar(str, ch));
    }

    public static String removeChar(String str, char ch) {
        String result = "";
        for (char c : str.toCharArray()) {
            if (c != ch) result += c;
        }
        return result;
    }
}

