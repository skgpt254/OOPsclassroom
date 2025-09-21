import java.util.Arrays;
public class sort {
    public static void main(String[] args) {
        int[] num = {0, 2, 1, 2, 0};
        Arrays.sort(num);
        for(int i : num){
            System.out.print(i+" ");
        }
    }
}
