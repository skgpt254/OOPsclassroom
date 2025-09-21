package Assignment3.Level1;

import java.util.Scanner;

public class IsFirstSmallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        boolean isSmallest = (a < b) && (a < c);
        System.out.println(isSmallest);
    }
}

