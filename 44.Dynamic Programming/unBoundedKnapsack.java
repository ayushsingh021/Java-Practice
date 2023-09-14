public class unBoundedKnapsack {
    

    public static int unboundedKnapsackMaxprofit(int val[] , int wt[] , int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];

        for(int i = 0 ; i < n+1 ;i++){
            dp[i][0] = 0;
        }
        for(int i = 0 ; i < W+1 ;i++){
            dp[0][i] = 0;
        }

        //tabulation
        for(int i = 1; i< n+1 ; i++){
            for(int j =1 ;j < W+1 ;j++){
                int Wt = wt[i-1]; //idx of val in 1 lesser than 2d dp arr
                int Val = val[i-1]; //idx of wt is 1 lesser than 2d dp arr 
                if(Wt<=j){
                    //valid
                    int include = Val + dp[i][j-Wt] ;
                    int exclude = dp[i-1][j];   
                    dp[i][j] = Math.max(include, exclude);
                }else{//invalid
                    //exclude
                    dp[i][j] = dp[i-1][j];
                }
            }
        } 

        return dp[n][W];
    }
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W= 7;
        System.out.println(unboundedKnapsackMaxprofit(val, wt, W));
    }
}
