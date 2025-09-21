package Assignment5.Level1;

public class Stringreverse {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("Hello");
        int n = str.length();
        int i = 0;
        int j = n-1;
        while(i<j){
            char temp = str.charAt(i);
            str.setCharAt(i,str.charAt(j));
            str.setCharAt(j,temp);
            i++;
            j--;
        }
        System.out.println(str);
    }
}

