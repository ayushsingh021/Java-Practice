// Given an integer array arr, partition the array into (contiguous) subarrays
// of length at most k. After partitioning, each subarray has their values
// changed to become the maximum value of that subarray.

// Return the largest sum of the given array after partitioning. Test cases are
// generated so that the answer fits in a 32-bit integer.

// Example 1:

// Input: arr = [1,15,7,9,2,5,10], k = 3
// Output: 84
// Explanation: arr becomes [15,15,15,9,10,10,10]
// Example 2:

// Input: arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
// Output: 83
// Example 3:

// Input: arr = [1], k = 1
// Output: 1


class Solution {
    public static int solve(int[] arr, int k , int curr , int[] dp){
        if(curr >= arr.length){
            return 0;
        }
        if(dp[curr] != -1){
            return dp[curr];
        }
        int maxNum = -1;
        int maxVal = 0 ;
        for(int j = curr ; j < arr.length &&  j-curr+1 <= k ;j++){
            maxNum = Math.max(maxNum , arr[j]);
            maxVal = Math.max( maxVal,  maxNum*(j-curr+1) + solve(arr, k , j+1 ,dp) );
        }
        return dp[curr] = maxVal;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[] = new int[arr.length+1];
        Arrays.fill(dp ,-1);
        return solve(arr , k , 0 ,dp);
    }
}