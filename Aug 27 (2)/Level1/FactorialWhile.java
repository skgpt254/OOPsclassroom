package Assignment3.Level1;

import java.util.Scanner;

public class FactorialWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        int n = sc.nextInt();
        if(n >= 0){
            int i = n, fact = 1;
            while(i>=1 ){
                fact = fact*i;
                i--;
            }
            System.out.println("Factorial is " + fact);
        }
        else{
            System.out.println("Invalid sc");
        }
    }
}
