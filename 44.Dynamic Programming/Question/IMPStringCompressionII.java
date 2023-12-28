// Run-length encoding is a string compression method that works by replacing consecutive identical characters (repeated 2 or more times) with the concatenation of the character and the number marking the count of the characters (length of the run). For example, to compress the string "aabccc" we replace "aa" by "a2" and replace "ccc" by "c3". Thus the compressed string becomes "a2bc3".

// Notice that in this problem, we are not adding '1' after single characters.

// Given a string s and an integer k. You need to delete at most k characters from s such that the run-length encoded version of s has minimum length.

// Find the minimum length of the run-length encoded version of s after deleting at most k characters.

 

// Example 1:

// Input: s = "aaabcccd", k = 2
// Output: 4
// Explanation: Compressing s without deleting anything will give us "a3bc3d" of length 6. Deleting any of the characters 'a' or 'c' would at most decrease the length of the compressed string to 5, for instance delete 2 'a' then we will have s = "abcccd" which compressed is abc3d. Therefore, the optimal way is to delete 'b' and 'd', then the compressed version of s will be "a3c3" of length 4.

class Solution {
    //'z' - 'a' = 25
      int[][][][] dp; //memoization 
    public int solve( String s , int i , int prev_char , int freq , int k ){
        //base case
        if(k < 0) return Integer.MAX_VALUE;
        if(i >= s.length() ) return 0;
        
        if(dp[i][prev_char][freq][k] != -1 ){
            return dp[i][prev_char][freq][k];
        }
        //options : 1. Delete ith_char 2.Keep ith_char
        //Delete_ith
        int del_i = solve(s , i+1 , prev_char , freq , k-1);

        int keep_i = 0 ;
        if(s.charAt(i) - 'a' != prev_char){
            //Length of RLE will inc by 1 for sure cause we are keeping one char for sure
            keep_i = 1 + solve(s , i+1 , s.charAt(i)-'a' , 1 , k); 
        }else{
            int one_more_addition = 0;
            if(freq == 1 || freq == 9 || freq == 99){
                one_more_addition = 1;
            }

            keep_i = one_more_addition + solve(s, i+1 , prev_char, freq+1 , k);
        }

        return dp[i][prev_char][freq][k] = Math.min(del_i , keep_i);
    }
 
    public int getLengthOfOptimalCompression(String s, int k) {
         int n = s.length();
         dp = new int[n][27][101][101];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 27; j++) {
                for (int p = 0; p < 101; p++) {
                    Arrays.fill(dp[i][j][p], -1);
                }
            }
        }
        return solve(s , 0 ,26 , 0 , k );
    }
}