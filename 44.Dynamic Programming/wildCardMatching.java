public class wildCardMatching { //LCS  Variation
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean dp[][]  = new boolean[m+1][n+1];
        //intialise
        dp[0][0] = true; 
        for(int i = 1 ; i< m+1 ;i++){
            dp[i][0] = false;
        }
        for(int j = 1 ; j < n+1 ; j++){
            if(p.charAt(j-1) =='*'){
                dp[0][j] = dp[0][j-1];
            }
        }

        for(int i =1 ; i < m+1 ; i++){
            for(int j =1 ; j < n+1 ; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*'){
                    boolean ignore = dp[i][j-1]; // remove *
                    boolean match = dp[i-1][j]; //replace * with char
                    dp[i][j] = (ignore || match );
                }
                else{
                    dp[i][j] = false;
                }
            }
        }

        return dp[m][n];

    }
    public static void main(String[] args) {
        String str1 = "baaabab";
        String str2 = "*****ba*****ab";

        System.out.println(isMatch(str1, str2));

    }
}
