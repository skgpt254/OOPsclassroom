package Assignment6.Level3;

import java.util.*;

public class NumberTypes {

    // Sum of proper divisors
    public static int sumDivisors(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++)
            if (n % i == 0) sum += i;
        return sum;
    }

    public static boolean isPerfect(int n) {
        return sumDivisors(n) == n;
    }

    public static boolean isAbundant(int n) {
        return sumDivisors(n) > n;
    }

    public static boolean isDeficient(int n) {
        return sumDivisors(n) < n;
    }

    public static boolean isStrong(int n) {
        int sum = 0, temp = n;
        while (temp > 0) {
            int d = temp % 10;
            int fact = 1;
            for (int i = 1; i <= d; i++) fact *= i;
            sum += fact;
            temp /= 10;
        }
        return sum == n;
    }

    public static void main(String[] args) {
        int n = 28; // example
        System.out.println("Perfect? " + isPerfect(n));
        System.out.println("Abundant? " + isAbundant(n));
        System.out.println("Deficient? " + isDeficient(n));
        System.out.println("Strong? " + isStrong(n));
    }
}

