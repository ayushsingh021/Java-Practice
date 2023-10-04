// Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

// You have the following three operations permitted on a word:

// Insert a character
// Delete a character
// Replace a character
 

// Example 1:

// Input: word1 = "horse", word2 = "ros"
// Output: 3
// Explanation: 
// horse -> rorse (replace 'h' with 'r')
// rorse -> rose (remove 'r')
// rose -> ros (remove 'e')
// Example 2:

// Input: word1 = "intention", word2 = "execution"
// Output: 5
// Explanation: 
// intention -> inention (remove 't')
// inention -> enention (replace 'i' with 'e')
// enention -> exention (replace 'n' with 'x')
// exention -> exection (replace 'n' with 'c')
// exection -> execution (insert 'u')
 

// Constraints:

// 0 <= word1.length, word2.length <= 500
// word1 and word2 consist of lowercase English letters.

public class editDistance {
    public static int minDistanceTab(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int dp[][] = new int[n+1][m+1];

        //initialise
        for(int i = 0 ; i < n+1 ; i++){
            dp[i][0] = i;
        }
        for(int i = 0 ; i < m+1 ; i++){
            dp[0][i] = i;
        }

        //LCS logic
        for(int i = 1; i < n+1 ; i++){
            for(int j =1 ; j < m+1 ; j++){
                //see last char
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    //same
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    //diff
                    //operations
                    int add = dp[i][j-1] +1;
                    int delete = dp[i-1][j] +1 ;
                    int replace = dp[i-1][j-1] +1;

                    dp[i][j] = Math.min(add , Math.min(delete , replace));
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "intention";
        String str2 = "execution";
        System.out.println(minDistanceTab(str1, str2));
    }
}
