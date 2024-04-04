// Given a string s, return the longest 
// palindromic
 
// substring
//  in s.

 

// Example 1:

// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.
// Example 2:

// Input: s = "cbbd"
// Output: "bb"
 


// Rec + Memo -- Lame Tarika hai but Always think abt rec cause then we can Memoise

class Solution {
    public static int cheakpalin(String s, int i, int j, int dp[][]) {
        if (i > j) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = cheakpalin(s, i + 1, j - 1, dp);
        }

        return 0;
    }

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        int n = s.length();

        int dp[][] = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        int maxLen = Integer.MIN_VALUE;
        String ans = "";
        ans += s.charAt(0);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (cheakpalin(s, i, j, dp) == 1) {
                    int len = j - i + 1;
                    if (len > maxLen) {
                        maxLen = len;
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }

        return ans;
    }
}