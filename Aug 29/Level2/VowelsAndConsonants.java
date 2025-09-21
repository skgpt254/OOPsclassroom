package Assignment5.Level2;

import java.util.*;

public class VowelsAndConsonants {
    static boolean isVowel(char c){ return "aeiouAEIOU".indexOf(c)!=-1; }
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine(); int v=0,c=0;
        for(char ch:s.toCharArray()) if(Character.isLetter(ch)) if(isVowel(ch)) v++; else c++;
        System.out.println("Vowels:"+v+" Consonants:"+c);
    }
}
