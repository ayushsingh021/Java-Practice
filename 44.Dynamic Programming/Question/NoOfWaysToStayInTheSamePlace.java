
//very impt ques just Drawing the Recursion tree is imp and then iy solves by itselff


// You have a pointer at index 0 in an array of size arrLen. At each step, you can move 1 position to the left, 1 position to the right in the array, or stay in the same place (The pointer should not be placed outside the array at any time).

// Given two integers steps and arrLen, return the number of ways such that your pointer is still at index 0 after exactly steps steps. Since the answer may be too large, return it modulo 109 + 7.

 

// Example 1:

// Input: steps = 3, arrLen = 2
// Output: 4
// Explanation: There are 4 differents ways to stay at index 0 after 3 steps.
// Right, Left, Stay
// Stay, Right, Left
// Right, Stay, Left
// Stay, Stay, Stay
// Example 2:

// Input: steps = 2, arrLen = 4
// Output: 2
// Explanation: There are 2 differents ways to stay at index 0 after 2 steps
// Right, Left
// Stay, Stay
// Example 3:

// Input: steps = 4, arrLen = 2
// Output: 8
 
class Solution {
    private int n;
    private int[][] dp;
    private final int MOD = 1000000007;
    public int numWays(int steps, int arrLen) {

        arrLen = Math.min(steps,arrLen);
        n = arrLen;

         dp = new int[501][501];
        for (int i = 0; i < 501; i++) {
            Arrays.fill(dp[i], -1);
        }
         arrLen = Math.min(arrLen, steps);
        return solve(steps , arrLen , 0,dp);
    }

     public int solve(int remStep , int arrL , int idx,int dp[][] ){
        //base
        if(remStep == 0){
            if(idx == 0){
                return 1;
            }else{
                return 0;
            }
        }

        if(idx < 0 || idx >= n){
            return 0;
        }
        if(dp[remStep][idx] != -1){
            return dp[remStep][idx];
        }

        int result = solve(  remStep - 1 ,arrL , idx+1 ,dp) % MOD; // RIGHT
        result = (result + solve( remStep - 1 ,arrL , idx-1 ,dp)) % MOD; // LEFT
        result = (result + solve( remStep - 1 ,arrL , idx ,dp)) % MOD; // STAY

        
        return dp[remStep][idx] = result;


    }
}
