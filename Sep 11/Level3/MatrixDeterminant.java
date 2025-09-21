package Assignment6.Level3;

public class MatrixDeterminant {

    // Method to calculate determinant of 3x3 matrix
    public static int determinant3x3(int[][] matrix) {
        if (matrix.length != 3 || matrix[0].length != 3) {
            throw new IllegalArgumentException("Matrix must be 3x3");
        }

        int a = matrix[0][0];
        int b = matrix[0][1];
        int c = matrix[0][2];
        int d = matrix[1][0];
        int e = matrix[1][1];
        int f = matrix[1][2];
        int g = matrix[2][0];
        int h = matrix[2][1];
        int i = matrix[2][2];

        int det = a*(e*i - f*h) - b*(d*i - f*g) + c*(d*h - e*g);
        return det;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int det = determinant3x3(matrix);
        System.out.println("Determinant of the 3x3 matrix is: " + det);
    }
}

