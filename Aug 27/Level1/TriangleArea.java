package Assignment2.Level1;

import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double base = sc.nextDouble();
        double h = sc.nextDouble();

        double areaCm2 = 0.5 * base * h;
        double areaIn2 = areaCm2 / 6.4516; 

        System.out.println(areaCm2);
        System.out.println(areaIn2);
    }
}

