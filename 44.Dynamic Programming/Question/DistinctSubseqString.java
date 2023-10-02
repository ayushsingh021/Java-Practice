// Given a string consisting of lower case English alphabets, the task is to find the number of distinct subsequences of the string
// Note: Answer can be very large, so, ouput will be answer modulo 109+7.

// Example 1:

// Input: 
// s = "gfg"
// Output: 
// 7
// Explanation: 
// The seven distinct subsequences are "", "g", "f", "gf", "fg", "gg" and "gfg" .
// Example 2:

// Input: 
// s = "ggg"
// Output: 
// 4
// Explanation: 
// The four distinct subsequences are "", "g", "gg", "ggg".
// Your task:
// You do not need to read any input or print anything. The task is to complete the function distinctSubsequences(), which takes a string as input and returns an integer.

// Expected Time Complexity: O(|str|)
// Expected Auxiliary Space: O(|str|)

// Constraints:
// 1 ≤ |s| ≤ 105
// s contains lower case English alphabets


class Solution {
  public static int distinctSubsequences(String s) {
        int mod = 1000000007;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
 
        Map<Character, Integer> mp = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            char ch = s.charAt(i - 1);
            dp[i] = (2 * dp[i - 1]) % mod;
            if (mp.containsKey(ch)) {
                int index = mp.get(ch);
                dp[i] = (dp[i] - dp[index - 1] + mod) % mod;
            }
            mp.put(ch, i);
        }
        return dp[n];
    }
 
}