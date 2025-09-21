package Assignment2.Level1;

import java.util.Scanner;

public class TotalPurchase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double unitP = sc.nextDouble();
        int q = sc.nextInt();

        double total = unitP * q;

       System.out.println(total);
    }
}

