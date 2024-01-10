

public class minimumPartitioning {
    
    public static int minimumDifference(int[] arr) {
        int sum = 0;
        for(int i= 0 ; i < arr.length ; i++){
            sum+=arr[i];
        }
        //0-1 knapsack logic 
        int n = arr.length;
        int W = sum/2;
        int dp[][] = new int [n+1][W+1];

        //initialization
        for(int i = 0 ; i < n+1 ; i++){
            dp[i][0] = 0 ;
        }
        for(int i = 0 ; i < W+1 ; i++){
            dp[0][i] = 0;
        }

        for(int i = 1; i < n+1 ; i++){
            for(int j =1; j< W+1 ; j++){
                if(arr[i-1]<= j){//valid
                    int include = arr[i-1] + dp[i-1][j-arr[i-1]];
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.max(include,exclude);
                }else{
                    //invalid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int sum1 = dp[n][W];
        int sum2 = Math.abs(sum - sum1);
        int diff = Math.abs(sum1 - sum2);
        return diff;
    }
    public static void main(String[] args) {
        int arr[] = {1,6,11,5};
        int ans = minimumDifference(arr);
        System.err.println(ans);

    }
}
