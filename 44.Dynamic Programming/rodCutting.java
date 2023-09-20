//same as unbounded knapsack
public class rodCutting {
    
    public static int unboundedKnapsackMaxprofit(int price[] , int length[] , int totRod){
        int n = price.length;
        int dp[][] = new int[n+1][totRod+1];

        for(int i = 0 ; i < n+1 ;i++){
            dp[i][0] = 0;
        }
        for(int i = 0 ; i < totRod+1 ;i++){
            dp[0][i] = 0;
        }

        //tabulation -- Unbounded knapsack
        // weight => length  val => price  W ==> totRod
        for(int i = 1; i< n+1 ; i++){
            for(int j =1 ;j < totRod+1 ;j++){
                int len = length[i-1]; //idx of price in 1 lesser than 2d dp arr
                int cost = price[i-1]; //idx of length is 1 lesser than 2d dp arr 
                if(len<=j){
                    //valid
                    int include = cost + dp[i][j-len] ;
                    int exclude = dp[i-1][j];   
                    dp[i][j] = Math.max(include, exclude);
                }else{//invalid
                    //exclude
                    dp[i][j] = dp[i-1][j];
                }
            }
        } 

        return dp[n][totRod];
    }

    public static void main(String[] args) {
        int length[] = {1,2,3,4,5,6,7,8};
        int price[] = {1,5,8,9,10,17,17,20};
        int totRod = 8;

        System.out.println(unboundedKnapsackMaxprofit(price, length, totRod));
    }
}
