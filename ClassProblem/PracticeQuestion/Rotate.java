public class Rotate {
      public static void reverse(int[] num,int st,int ed) {
        while(st<ed){
            int temp = num[st];
            num[st] = num[ed];
            num[ed] = temp;
            st++;
            ed--;
        }

    }
    public static void Reverarr(int[] num,int n,int k) {
        reverse(num,0,n-k-1);
        reverse(num,n-k,n-1);
        reverse(num,0,n-1);
    }
    public static void main(String[] args) {
        int[] num = {1,2,3,4,5};
        int n = num.length;
        int k = 1;
        Reverarr(num,n,k);
        for(int val : num){
            System.out.print(val+" ");
        }
    }
}
