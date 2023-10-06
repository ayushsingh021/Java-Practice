public class countBsts {
    public static void main(String[] args) {
        int n = 4;

         //catalan numbers concept
       int dp[] = new int[n+1];
       dp[0]=1;
       dp[1]=1;

       for(int i = 2; i < n+1 ; i++){
           for(int j = 0 ; j < i ; j ++){
               dp[i] += dp[j] * dp[i-j-1];  // Cn = Ci* C(n-i-1) 
           }
       }

       System.out.println(dp[n]);
    }
}
