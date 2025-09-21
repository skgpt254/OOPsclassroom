package Assignment3.Level1;

import java.util.Scanner;

public class DivisibleByFive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        boolean isDivisible = true;
        if(number%5 != 0){
            isDivisible = false;
        }
        System.out.println(isDivisible);
    }
}

