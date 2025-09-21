package Assignment5.Level3;
import java.util.Scanner;

public class UniqueCharacters {
    static char[] findUniqueChars(String str) {
        int n = str.length();
        char[] unique = new char[n];
        int index = 0;

        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            boolean found = false;
            for (int j = 0; j < index; j++) {
                if (unique[j] == c) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                unique[index++] = c;
            }
        }

        char[] result = new char[index];
        for (int i = 0; i < index; i++) {
            result[i] = unique[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = sc.nextLine();

        char[] unique = findUniqueChars(str);
        System.out.print("Unique Characters: ");
        for (char c : unique) System.out.print(c + " ");
    }
}

