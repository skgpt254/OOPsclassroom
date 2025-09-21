public class MoveAllnegativetoOneSide {
    public static void main(String[] args) {
        int [] num = {1, -1, 3, 2, -7, -5, 11, 6};
        int n = num.length;
        int j = 0;
        for(int i=0;i<n-1;i++){
           if(num[i]<0){
            if(i != j){
                int temp = num[i];
                num[i] = num[j];
                num[j] = temp;
            }
            j++;
           }
        }
        for(int i : num){
            System.out.print(i+" ");
        }
    }
}
