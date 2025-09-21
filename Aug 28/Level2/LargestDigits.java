package Assignment4.Level2;

public class LargestDigits {
    public static void findmax(int[] arr,int n) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(max<arr[i]){
                max = arr[i];
            }
        }
        int smax = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(smax<arr[i] && max>arr[i]){
                smax = arr[i];
            }
        }
        System.out.println(max);
        System.out.println(smax);
    }
    public static void main(String[] args) {
//      Scanner sc = new Scanner(System.in);
      int[] arr = {2,4,67,59,39,98};
      int n = arr.length;
      findmax(arr,n);
    }
}
