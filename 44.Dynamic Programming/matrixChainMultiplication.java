import java.util.Arrays;

public class matrixChainMultiplication{
    
    
    // public static int mcmRec(int arr[] , int i , int j ){
    //     if(i == j ){
    //         //single matrix;
    //         return 0;
    //     }
    //     //Ai == arr[i-1]*arr[i]
    //     int ans = Integer.MAX_VALUE;
    //     for(int k = i ; k <= j-1 ; k++){
    //         int cost1 = mcmRec(arr, i, k); //set1 -- arr[i-1]xarr[k] -- < Ai.....Ak
    //         int cost2 = mcmRec(arr, k+1, j); //set1 -- arr[k]xarr[j] -- < Ak+1.....Aj
    //         int cost3 = arr[i-1]*arr[k]*arr[j];
    //         int totalCost = cost1 + cost2+ cost3;
    //         ans = Math.min(ans,totalCost) ;
    //     }

    //     return ans;
    // }

    public static int mcmMemo(int arr[] , int i , int j, int dp[][] ){
        if(i == j ){
            //single matrix;
            return 0;
        }
        //Ai == arr[i-1]*arr[i]
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for(int k = i ; k <= j-1 ; k++){
            int cost1 = mcmMemo(arr, i, k,dp); //set1 -- arr[i-1]xarr[k] -- < Ai.....Ak
            int cost2 = mcmMemo(arr, k+1, j,dp); //set1 -- arr[k]xarr[j] -- < Ak+1.....Aj
            int cost3 = arr[i-1]*arr[k]*arr[j];
            int totalCost = cost1 + cost2+ cost3;
            ans = Math.min(ans,totalCost) ;
        }

        return dp[i][j] = ans;
    }
    
    public static int mcmTab(int arr[]){
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i<n ; i++){
            dp[i][i] = 0;
        }

        for(int len =2 ; len<=n-1 ; len++){
            for(int i = 1; i <= n-len ; i++){
                //i -- start
                int j = i+len-1; //end
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i ; k <= j-1 ; k++){
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1]*arr[k]*arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost1+cost2+cost3);
                }
            }
        }

        return dp[1][n-1];
    }
    
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};//n=5
        int n = arr.length;
        int dp[][] = new int[n][n];
        for(int i= 0  ;i < n ; i++){
           Arrays.fill(dp[i],-1);
        }
        System.out.println(mcmMemo(arr, 1, n-1 ,dp));
        System.out.println(mcmTab(arr));
    }
}
