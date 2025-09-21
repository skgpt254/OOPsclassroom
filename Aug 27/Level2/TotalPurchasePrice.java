package Assignment2.Level2;

import java.util.Scanner;

public class TotalPurchasePrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double unitPrice = sc.nextDouble();

        int quantity = sc.nextInt();

        double total = unitPrice * quantity;

        System.out.println(total);
}

}