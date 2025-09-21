package Assignment4.Level1;

import java.util.Scanner;

public class MatrixTo1D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int rows = sc.nextInt();
       
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];
        int[] Array = new int[rows * cols];
        int index = 0;

        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
                Array[index] = matrix[i][j];
                index++;
            }
        }

        System.out.println("1D Array:");
        for (int val : Array) {
            System.out.print(val + " ");
        }
    }
}

