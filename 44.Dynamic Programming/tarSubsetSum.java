public class tarSubsetSum {
    
    public static boolean subsetSum(int n, int[]arr , int sum){
       
        boolean dp[][] = new boolean[n+1][sum+1];
        //intialization
        for(int i = 0 ; i < dp.length ; i++){
            dp[i][0] = true; 
        }

        for(int i = 1 ; i < n+1 ; i++){
            for(int j = 0 ; j < sum+1 ; j++){
                //valid
                int V = arr[i-1];
                if(V <= j && dp[i-1][j-V] == true){
                    dp[i][j] = true;
                }
                //exclude
                else if(dp[i-1][j] == true){
                    dp[i][j] = true;
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int arr[]= {4,2,7,1,3};
        int n = arr.length;
        int sum =10 ;
        System.out.println(subsetSum(n,arr,sum));
    }
}
