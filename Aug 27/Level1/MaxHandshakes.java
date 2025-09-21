package Assignment2.Level1;

import java.util.Scanner;

public class MaxHandshakes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int handshakes = (n * (n - 1)) / 2;
        System.out.println(handshakes);
    }
}

