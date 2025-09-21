package Assignment6.Level1;

import java.util.Scanner;

public class SumNatural {
    static int sumN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) sum += i;
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.println("Sum = " + sumN(n));
    }
}

