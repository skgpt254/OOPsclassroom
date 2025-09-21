import java.util.Arrays;
public class Kthelement {
    public static void main(String[] args) {
        int[] num = {7, 10, 4, 3, 20, 15};
        int k = 3;
        Arrays.sort(num);
        int n = num.length;
        if(k>=n){
            System.out.println("Array overflow");
        }
        else{
            System.out.println(num[k-1]);
            System.out.println(num[n-k]);
        }
    }
}
