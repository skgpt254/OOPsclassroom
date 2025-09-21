package Assignment4.Level2;
import java.util.Scanner;

public class TwoDarray {
      public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int r = sc.nextInt();
       int c = sc.nextInt();
       int[][] arr = new int[r][c];
       for(int i=0;i<r;i++){
           for(int j=0;j<c;j++){
               arr[i][j] = sc.nextInt();
           }
       }
       for(int j=0;j<c;j++){
            for(int i=0;i<r;i++){
                System.out.print(arr[i][j]+" ");
            }
           System.out.println();
        }
    }
}
