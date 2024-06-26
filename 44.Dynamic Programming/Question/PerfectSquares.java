// 279. Perfect Squares
// Solved
// Medium
// Topics
// Companies
// Given an integer n, return the least number of perfect square numbers that sum to n.

// A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

// Example 1:

// Input: n = 12
// Output: 3
// Explanation: 12 = 4 + 4 + 4.
// Example 2:

// Input: n = 13
// Output: 2
// Explanation: 13 = 4 + 9.

//Rec + Memo
class Solution {
    public static int solve(int n, int[] dp) {
        if (n == 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int minCnt = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int res = 1 + solve(n - i * i, dp);
            minCnt = Math.min(minCnt, res);
        }

        return dp[n] = minCnt;
    }

    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }
}
// Tablualtion --bottom uop

class Solution {
    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, 100000);
        dp[0] = 0;
        // dp[i] -- i sum ke lie kitne perfect sq chahiye (smaller problem to bigger)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }

        return dp[n];
    }
}