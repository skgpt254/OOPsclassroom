package Assignment7.ProblemStatement;
import java.util.Scanner;
public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(reverse(str));
    }
    public static String reverse(String str){
        String rev = "";
        for(int i = str.length()-1;i >= 0;i--){
            rev += str.charAt(i);
        }
        return rev;
    }
}
