import java.util.*;
public class catalanNumber {
    
    public static int catalanRec(int n){
        //base case
        if(n == 0 || n == 1){
            return 1;
        }
        int ans= 0; //Cn
        for(int i = 0 ; i < n ; i++){
            ans += catalanRec(i) * catalanRec(n-i-1);
        }

        return ans;
    }
    public static int catalanMem(int n , int dp[]){
        //base case
        if(n == 0 || n == 1){
            return 1;
        }

        if(dp [n] != -1){
            return dp[n];
        }
        int ans= 0; //Cn
        for(int i = 0 ; i < n ; i++){
            ans += catalanMem(i ,dp) * catalanMem(n-i-1 ,dp);
        }

        return dp[n] = ans;
    }

    public static int catalanTab(int n ){
        int dp[] = new int[n+1];
        //intialise 
        dp[0] = 1;
        dp[1] =1;
        for(int i = 2 ; i<= n; i++){
            for(int  j = 0 ; j < i ; j++){
                dp[i] += dp[j]*dp[i-j-1];
            }
        } 
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 4;
       
        // int dp[] = new int[n+1];
        // for(int i = 0 ; i < n+1 ; i++){
        //     dp[i]= -1;
        // }
        // Arrays.fill(dp , -1);
        System.out.println(catalanRec(n));
        // System.out.println(catalanMem(n , dp));
        System.out.println(catalanTab(n ));

    }
}
