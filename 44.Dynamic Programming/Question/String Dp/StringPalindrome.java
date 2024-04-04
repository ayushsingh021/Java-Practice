// Given a string s, return the number of palindromic substrings in it.

// A string is a palindrome when it reads the same backward as forward.

// A substring is a contiguous sequence of characters within the string.

 

// Example 1:

// Input: s = "abc"
// Output: 3
// Explanation: Three palindromic strings: "a", "b", "c".
// Example 2:

// Input: s = "aaa"
// Output: 6
// Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 



//Blueprint --Use any Palindrome related question
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];

        // Bottom Up -- State : dp[i][j] -- Substring starting from i and enfing at j if
        // Palin -True
        // -- not Palin --False

        int cnt = 0;
        for (int Len = 1; Len <= n; Len++) {
            for (int i = 0; i + Len - 1 < n; i++) {
                int j = i + Len - 1;
                if (i == j) {// 1 length substr
                    dp[i][j] = true;
                } else if (i + 1 == j) {
                    // 2 length substr
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else { // genric
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }

                if (dp[i][j]) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}

// Rec + Memo
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

    public int countSubstrings(String s) {
        int n = s.length();

        int dp[][] = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (cheakpalin(s, i, j, dp) == 1) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}