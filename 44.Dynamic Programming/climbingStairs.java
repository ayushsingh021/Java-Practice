import java.util.*;
public class climbingStairs{
    //recursion -- TLE
    public static int countWays(int n){
        if(n == 0){
            return 1;
        }else if( n < 0){
            return 0;
        }

        //same as fibbo logic
        int way1 = countWays(n-1);
        int way2 = countWays(n-2);
        return way1 + way2;
    }

        // Memoization --
    public static int countWaysMemo(int n , int dp[]){
        //base  case
       if (n == 0 ) {
           return 1;
       }else if( n < 0 ){
           return 0;
       }
       if(dp[n] != -1){
           return dp[n];
       }

       dp[n] = countWaysMemo(n-1 ,dp) + countWaysMemo(n-2,dp);

       return dp[n];
   }

   //tabulation
   public static int countWaysTab(int n) {
    
    int dp[] = new int[n+1];
    dp[0] = 1;

    for(int i  = 1 ; i <= n ; i++){
        if(i==1) {
            dp[i] = dp[i-1];
        }else{
            dp[i] = dp[i-1] + dp[i-2];
        }
    }

    return dp[n];
   }
    public static void main(String[] args) {
        int n = 5 ;
        int ways[] = new int[n+1];
        Arrays.fill(ways,-1); 
        // System.out.println(countWays(n));
        System.out.println("Memoization : " + countWaysMemo(n , ways));
        System.out.println( "Tabulation :" + countWaysTab(n));

    }
}