package Assignment4.Level1;

import java.util.Scanner;

public class StoreValuesUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] arr = new double[10];
        int index = 0;
        while(true){
            double num = sc.nextDouble();
            if(num<=0){
                break;
            }
            if(index < 10){
                arr[index] = num;
                index++;
            }
            else {
                System.out.println("Array is full");
                break;
            }
        }
        double sum = 0.0;
        for(int i=0;i<index;i++){
            sum += arr[i];
        }
        System.out.println("Total sum = "+sum);
    }
}
