public class MaxandMin {
      public static void findmax(int[] arr,int n) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(max<arr[i]){
                max = arr[i];
            }
        }
        int min= Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(min>arr[i]){
                min = arr[i];
            }
        }
        System.out.println(max);
        System.out.println(min);
    }
    public static void main(String[] args) {
      int[] arr = {3,5,1,8,-2};
      int n = arr.length;
      findmax(arr,n);
    }
}
