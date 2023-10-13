public class longestCommonSubstring {
    public static int longestCommonSubstrTab(String S1, String S2, int n, int m){
        int dp[][] = new int [n+1][m+1];
        for(int i = 0 ; i < n+1 ; i++){
            dp[i][0] = 0;
        }
        
        for(int i = 0 ; i < m+1 ; i++){
            dp[0][i] = 0;
        }
        
        int ans = 0;
        //bottom up
        for(int i = 1 ; i< n+1 ; i++){
            for(int j = 1; j < m+1 ; j++){
                if(S1.charAt(i-1) == S2.charAt(j-1)){
                    //same
                    dp[i][j] = dp[i-1][j-1]+1;
                     ans = Math.max(ans, dp[i][j]);
                }else{
                    //diff
                    dp[i][j] = 0;
                }
               
            }
        }
        
        return ans;

    }
    public static void main(String[] args) {
        // String s1 = "ABCDE";
        // String s2 = "ABGCE";

        String s1 = "1100011000";
        String s2 = "0101001010";
        int m = 10;
        int n = 10;
        // longestCommonSubstrTab(s1, s2, n, m);
        System.out.println(longestCommonSubstrTab(s1, s2, n, m));
    }
}
