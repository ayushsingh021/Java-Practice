// You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

// You can either start from the step with index 0, or the step with index 1.

// Return the minimum cost to reach the top of the floor.

 

// Example 1:

// Input: cost = [10,15,20]
// Output: 15
// Explanation: You will start at index 1.
// - Pay 15 and climb two steps to reach the top.
// The total cost is 15.
// Example 2:

// Input: cost = [1,100,1,1,1,100,1,1,100,1]
// Output: 6
// Explanation: You will start at index 0.
// - Pay 1 and climb two steps to reach index 2.
// - Pay 1 and climb two steps to reach index 4.
// - Pay 1 and climb two steps to reach index 6.
// - Pay 1 and climb one step to reach index 7.
// - Pay 1 and climb two steps to reach index 9.
// - Pay 1 and climb one step to reach the top.
// The total cost is 6.

//Memoiazation
class Solution {
    public static int solve(int cost[] , int i , int n , int[] dp){
        //base case
        if(i >= n){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int way1 = cost[i] +  solve(cost , i+1 , n,dp);
        int way2 = cost[i] + solve(cost , i+2 , n,dp);

        return dp[i] = Math.min(way1 , way2);
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp [] = new int[n+1];
        Arrays.fill(dp , -1);
        return Math.min(solve(cost , 0 , n ,dp ), solve(cost , 1  , n,dp));

    }
}

//tablulation -- Bottom up


 public int minCostClimbingStairs(int[] cost) {
        int n = cost.length-1;
        int dp [] = new int[n+1];
       
       dp[0] = cost[0];
       dp[1] = cost[1];
       for(int i = 2; i < n+1 ;i++){
        dp[i] = cost[i] + Math.min(dp[i-1],dp[i-2]);
       }

       return Math.min(dp[n] ,dp[ n-1]);

    }