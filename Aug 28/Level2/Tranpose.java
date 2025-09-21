package Assignment4.Level2;
import java.util.Scanner;
public class Tranpose {
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
        int[] a = new int[r*c];
        for(int i=0;i<r*c;i++){
            for(int j=0;j<c;j++){
                a[i] = arr[i][j];
            }
        }
        for(int num : a){
            System.out.print(num+" ");
        }
    }
}
