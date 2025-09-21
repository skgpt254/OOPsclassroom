package Assignment5.Level2;

import java.util.*;

public class TrimSpaces {
    static String trim(String s){
        int st=0,en=s.length()-1;
        while(st<=en && s.charAt(st)==' ') st++;
        while(en>=st && s.charAt(en)==' ') en--;
        return s.substring(st,en+1);
    }
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println("Trimmed: '"+trim(s)+"'");
    }
}