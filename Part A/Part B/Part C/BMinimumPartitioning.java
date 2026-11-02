
//partitioning subset or min subset diff
public class BMinimumPartitioning { //Variation of 0-1 knapsack(as it is)
    
    public static int minPartition(int arr[]) {
        int n = arr.length;
        int sum =0;
        for(int i =0; i<arr.length; i++) {
            sum += arr[i];
        }

        int W = sum/2;

        int dp[][] = new int[n+1][W+1];
        //skipping initialization part ...by default it is already in java

        //bottom up
        for(int i =1; i<n+1; i++) {
            for(int j=1; j<W+1; j++ ) {
               if(arr[i-1] <= j) {// valid 
                   //include                                           ,exclude 
                   dp[i][j] = Math.max(arr[i-1] + dp[i-1][j-arr[i-1]], dp[i-1][j]);
               }else { //invalid 
                   dp[i][j] = dp[i-1][j];
               }
            }
         }
         int sum1 = dp[n][W];
         int sum2 = sum - sum1;
         return Math.abs(sum1 - sum2);
      }
    
    public static void main(String[] args) {
        int nums[] = {1, 6, 11, 5};

        System.out.println(minPartition(nums));
    }
}
