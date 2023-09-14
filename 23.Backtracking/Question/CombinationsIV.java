// Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

// The test cases are generated so that the answer can fit in a 32-bit integer.

 

// Example 1:

// Input: nums = [1,2,3], target = 4
// Output: 7
// Explanation:
// The possible combination ways are:
// (1, 1, 1, 1)
// (1, 1, 2)
// (1, 2, 1)
// (1, 3)
// (2, 1, 1)
// (2, 2)
// (3, 1)
// Note that different sequences are counted as different combinations.
// Example 2:

// Input: nums = [9], target = 3
// Output: 0

//backtracking and Recursion approach -- O(2^n) -- TLE 
//backtracking template of without for loop - MIK
class Solution {

    // //backtracking(without for loop take- rej format) -- TLE --- > memoize -Dp
    // public static int solve(int idx , int target , int[] nums ,  int dp [][]){
    //     if( target == 0 ){
    //         return 1;
    //     }
    //     if( idx >= nums.length || target<0 ){
    //         return 0;
    //     }
    //     //dp 
    //     if(dp[idx][target] != -1){
    //         return dp[idx][target];
    //     }
    //     int take_idx  = solve(0 , target - nums[idx] , nums,dp);
    //     int rej_idx = solve(idx+1 , target , nums ,dp);

    //     //  return take_idx + rej_idx ; //only backtracking
    //     return dp[idx][target] = take_idx + rej_idx ;
    // }


//backtracking(with for loop take- rej(forloop) format) -- TLE --- > memoize -Dp
    public static int solve(int idx , int target , int[] nums ,  int dp [][]){
        if( target == 0 ){
            return 1;
        }
        if( idx >= nums.length || target<0 ){
            return 0;
        }
        //dp 
        if(dp[idx][target] != -1){
            return dp[idx][target];
        }
        int result= 0 ;
        for(int i= idx ; i < nums.length ; i++){
            int take_i = solve(0 , target - nums[i] , nums,dp);
            result += take_i;
        }
        
        return dp[idx][target] = result;
    }

    public int combinationSum4(int[] nums, int target) {
        int dp [][] = new int[201][1001];
        for(int i = 0 ; i < 201 ; i++){
            for(int j = 0 ; j < 1001 ;j++){
                dp[i][j] = -1;
            }
        }
      return solve(0 , target , nums ,dp);
    }


    // --super optimiezed  -- Tabulation
    public int combinationSum4(int[] nums, int target) {
      

        int dp[] = new int[target+1];
        dp[0] =1;
        for(int currTar = 1 ; currTar <= target ; currTar++){
            for( Integer num : nums){
                if( num <= currTar  ){
                    dp[currTar] += dp[currTar - num];
                }
            }
        }

        return dp[target];
     
    }
}

