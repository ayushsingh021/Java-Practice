public class longestCommonSubsequence {
    
    public static int lcsMem (String str1, String str2 , int m ,int n , int dp[][]){
        if(m==0 || n==0) {
            return 0;
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }

        if(str1.charAt(m-1) == str2.charAt(n-1)){
            //same --(last char)
            return dp[m][n] = lcsMem(str1, str2 ,m-1 , n-1 ,dp)+1;
        }else{
            //diff -- (last char)
            int ans1= lcsMem(str1, str2 , m-1 , n ,dp);
            int ans2=  lcsMem(str1, str2 , m , n-1 ,dp);
            return dp[m][n]=  Math.max(ans1,ans2);
        }
    }
    public static int lcsRec (String str1, String str2 , int m ,int n ){
        if(m==0 || n==0) {
            return 0;
        }
      

        if(str1.charAt(m-1) == str2.charAt(n-1)){
            //same --(last char)
            return lcsRec(str1, str2 ,m-1 , n-1 )+1;
        }else{
            //diff -- (last char)
            int ans1= lcsRec(str1, str2 , m-1 , n );
            int ans2=  lcsRec(str1, str2 , m , n-1 );
            return Math.max(ans1,ans2);
        }
    }
    
    public static int lcsTab(String str1 , String str2){
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];
        for(int i = 0 ; i < dp.length ; i++){
            dp[i][0] = 0;
        } 
        for(int i = 0 ; i < dp[0].length ; i++){
            dp[0][i] = 0;
        } 

        for(int i = 1 ; i < n+1 ; i++){
            for(int j = 1; j < m+1 ; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    //same
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    //diff
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];

                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        return dp[n][m];
    }
    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg"; //lcs ="abdg" --;leangth 4
        int m = str1.length();
        int n =  str2.length();
        int dp[][] = new int[m+1][n+1];
        for(int i = 0 ; i < m+1 ; i ++){
            for(int j = 0 ; j < n+1 ; j++){
                dp[i][j] = -1;
            }
        }

        System.out.println(lcsMem(str1, str2,m ,n ,dp));
        System.out.println(lcsTab(str1, str2));
    }
}
