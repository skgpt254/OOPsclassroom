package Assignment6.Level2;

import java.util.Scanner;

public class SumNaturalNumbers {

    static int sumRecursive(int n) {
        if (n == 0) return 0;
        return n + sumRecursive(n - 1);
    }

    static int sumFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int recursiveSum = sumRecursive(n);
        int formulaSum = sumFormula(n);

        System.out.println("Recursive Sum = " + recursiveSum);
        System.out.println("Formula Sum = " + formulaSum);

        if (recursiveSum == formulaSum)
            System.out.println("Both results are same");
        else
            System.out.println("Mismatch");
    }
}

