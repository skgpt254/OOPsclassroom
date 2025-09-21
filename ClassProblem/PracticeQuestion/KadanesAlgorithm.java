public class KadanesAlgorithm {
    public static void main(String[] args) {
        int[] num = {-2, -3, 4, -1, -2, 1, 5, -3};
        // int n = num.length;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i : num){
            currSum += i;
            maxSum = Math.max(currSum,maxSum);
            if(currSum < 0){
                currSum = 0;
            }
        }
        System.out.println(maxSum);
    }
}
