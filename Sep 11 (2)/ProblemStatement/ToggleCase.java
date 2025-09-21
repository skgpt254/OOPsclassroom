package Assignment7.ProblemStatement;

import java.util.Scanner;

public class ToggleCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.println("Toggled String: " + toggleCase(str));
    }

    public static String toggleCase(String str) {
        String result = "";
        for (char ch : str.toCharArray()) {

            if (Character.isUpperCase(ch)){
            result += Character.toLowerCase(ch);
            }
            
            else if (Character.isLowerCase(ch)){ 
            result += Character.toUpperCase(ch);
            }

            else{ 
            result += ch;
            }

        }
        return result;
    }
}

