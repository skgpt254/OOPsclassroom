package Assignment2.Level2;
import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double base = sc.nextDouble();

        double height = sc.nextDouble();

        double areaCm2 = 0.5 * base * height;
        double areaIn2 = areaCm2 / 6.4516;

       System.out.println(areaIn2);
    }
}

