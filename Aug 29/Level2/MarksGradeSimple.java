package Assignment5.Level2;

import java.util.Scanner;

public class MarksGradeSimple {
    static char getGrade(double percent) {
        if (percent >= 90) return 'A';
        else if (percent >= 75) return 'B';
        else if (percent >= 50) return 'C';
        else return 'D';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] marks = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                marks[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2]; 
            double percent = total / 3.0;                       
            char grade = getGrade(percent);                     

            System.out.println((i + 1) + " " + total + " " + Math.round(percent) + " " + grade);
        }
    }
}


