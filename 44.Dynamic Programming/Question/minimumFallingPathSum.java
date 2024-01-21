
//lc 931

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];
        for (int i = 0; i < m; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int minVal = Integer.MAX_VALUE;
                if (i - 1 >= 0 && j - 1 >= 0) {
                    minVal = Math.min(dp[i - 1][j - 1], minVal);
                }
                if (i - 1 >= 0) {
                    minVal = Math.min(dp[i - 1][j], minVal);
                }
                if (i - 1 >= 0 && j + 1 < m) {
                    minVal = Math.min(dp[i - 1][j + 1], minVal);
                }
                dp[i][j] = matrix[i][j] + minVal;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            if (ans > dp[n - 1][i]) {
                ans = dp[n - 1][i];
            }
        }
        return ans;
    }
}
