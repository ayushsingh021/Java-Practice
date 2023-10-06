public class stringConversion {
    public static void main(String[] args) {
        String str1= "pear";
        String str2= "sea";

        int m = str1.length();
        int n = str2.length();

        int dp[][] = new int[m+1][n+1];

        //initialise
        for(int i = 0 ; i < m+1 ; i++){
            dp[i][0] = 0; 
        }
        for(int i = 0 ; i < n+1 ; i++){
            dp[0][i] = 0; 
        }

        //LCS of both str1 and str2 -- > to convert we need to remove the alphabets of str1 not is lcs and insert 
        //the alphabets which are is str2 but not in lcs

        for(int i = 1 ; i < m+1; i++){
            for(int j = 1 ; j < n+1 ; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    //same
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    int ans1 = dp[i-1][j] ;
                    int ans2 = dp[i][j-1] ;

                    dp[i][j] = Math.max(ans1, ans2);
                }
            } 
        }

        int lcsLen = dp[m][n];

        int delStep = m - lcsLen;
        int insertStep= n - lcsLen;

        int totalStep = delStep + insertStep;

        System.out.println(totalStep);

    }
}
