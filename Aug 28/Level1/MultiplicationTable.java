package Assignment4.Level1;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        int number = sc.nextInt();
        int[] table = new int[10];

        for (int i = 0; i < table.length; i++) {
            table[i] = number*(i+1);
            System.out.println(number + " * " + i + " = " + table[i]);
        }
    }
}

