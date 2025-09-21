package Assignment6.Level2;

import java.util.Random;

public class RandomStats {
    static int[] generate(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = 1000 + rand.nextInt(9000);
        return arr;
    }

    static void findStats(int[] arr) {
        int min = arr[0], max = arr[0], sum = 0;
        for (int n : arr) {
            if (n < min) min = n;
            if (n > max) max = n;
            sum += n;
        }
        System.out.println("Average = " + (sum / arr.length));
        System.out.println("Min = " + min);
        System.out.println("Max = " + max);
    }

    public static void main(String[] args) {
        int[] arr = generate(5);
        System.out.print("Numbers: ");
        for (int n : arr) System.out.print(n + " ");
        System.out.println();
        findStats(arr);
    }
}

