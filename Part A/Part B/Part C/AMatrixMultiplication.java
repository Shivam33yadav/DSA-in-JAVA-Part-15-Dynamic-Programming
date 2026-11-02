
import java.util.*;
public class AMatrixMultiplication { //Memoization => T.C is O(n^2)


    public static int mcmMem(int arr[], int i, int j, int dp[][]) {
        if(i == j) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for(int k =i; k<=j-1; k++) {
            int cost1 = mcmMem(arr, i, k, dp);
            int cost2 = mcmMem(arr, k+1, j, dp);
            int cost3 = arr[i-1]* arr[k] *arr[j];
            int totalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, totalCost);
        }

        return dp[i][j] = ans;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 3}; //n = 5
        int n = arr.length;

        int dp[][] = new int[n][n];
        for(int i =0; i<n; i++) {
            Arrays.fill(dp[i], -1); //har baar 1d arr ko nikalenge and fill -1  row wise 

            
        }
         System.out.println(mcmMem(arr, 1, n-1, dp));
    }
}
