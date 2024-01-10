import java.util.Arrays;

public class minimumJumps {

    // public static int minJumpsTab(int arr[]){
    //     int n = arr.length;
    //     int dp[] = new int[n];
    //     Arrays.fill(dp, -1);
    //     dp[n-1] = 0 ;//initialization
    //     for(int i = n-2 ; i>= 0 ; i--){
    //         int steps = arr[i];
    //         int ans = Integer.MAX_VALUE;
    //         for(int j = i+1 ; j <= i+steps && j <n ; j++){
    //             if(dp[j] != -1){
    //                 ans = Math.min(ans, dp[j]+1);
    //             }
    //         }
    //         if(ans != Integer.MAX_VALUE){
    //             dp[i] = ans;
    //         }
    //     }
    //     // i -- n-1 ith idx to n-1 req steps
    //     return dp[0];
    // }

  
        public static int minJumpsMemo(int[] arr , int idx , int dp[] ){
            if(idx >= arr.length-1 ){
                return 0;
            }
            if(arr[idx] == 0) return 100000;
            int minStep = Integer.MAX_VALUE;
            
            if(dp[idx] != -1){
                return dp[idx];
            }
    
            for(int i = 1; i <= arr[idx] ; i++){
                int newIdx = idx + i;
                int currStep = 1 + minJumpsMemo(arr , newIdx,dp);
                minStep = Math.min(minStep , currStep);
            }
           
    
            return dp[idx] = minStep;
        }
    
    public static void main(String[] args) {
        int arr[] = {2,3,1,1,4};
        // System.out.println(minJumpsTab(arr));
        
        int n = arr.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp , -1);
        System.out.println(minJumpsMemo(arr, 0, dp));

    }
}
