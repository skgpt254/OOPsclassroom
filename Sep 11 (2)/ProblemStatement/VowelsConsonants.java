package Assignment7.ProblemStatement;

import java.util.Scanner;
public class VowelsConsonants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        countVowelsandConsonants(str);
    }
    public static void countVowelsandConsonants(String str){
        int vowelcount = 0;
        int consonantcount = 0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                vowelcount++;
            }
            else{
                consonantcount++;
            } 
        }
        System.out.println("Vowels : "+vowelcount);
        System.out.println("Consonants : "+consonantcount);
    }
}
