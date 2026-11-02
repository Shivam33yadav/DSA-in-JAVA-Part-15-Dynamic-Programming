import java.util.*;
public class CCatalansNumberTabulation {
    public static int catalanTab(int n) { //T.C -> O(n^2)
        int dp[] = new int[n+1];
        dp[0] = 1; //always known 
        dp[1] = 1; // always
        
        for(int i =2; i<=n; i++) { //Catalan of i will be calc 
            for(int j = 0; j<i; j++) {
                dp[i] += dp[j] * dp[i-j-1]; //Ci = Cj * Ci-j-1
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(catalanTab(5));
        
    }
}
