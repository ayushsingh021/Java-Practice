import java.util.*;

public class longestIncreasingSubsseq{
    public static int lengthOfLISTab(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++){
            hs.add(nums[i]);
        }
        int arr[] = new int[hs.size()]; // sorted unique eles
        Iterator<Integer> itr = hs.iterator();
        int k = 0 ;
        while(itr.hasNext()){
            arr[k] = itr.next();
            k++;
        }
        Arrays.sort(arr);

        //LCS of both arr(sorted) & num will give LIS sol
        int n = nums.length;
        int m = arr.length ;
        int dp[][] = new int[n+1][m+1];

        //intialise
        for(int i = 0 ; i < n+1 ; i++){
            dp[i][0] = 0 ;
        }
        for(int i = 0 ; i < m+1 ; i++){
            dp[0][i] = 0 ;
        }

        //bottom up
        for(int i = 1 ; i < n+1 ; i++){
            for(int j = 1 ; j < m+1 ; j++){
                if(nums[i-1] == arr[j-1]){
                    //same
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    //diff
                    int ans1 = dp[i-1][j];
                    int ans2= dp[i][j-1];

                    dp[i][j] = Math.max(ans1 , ans2);
                }
            }
        }

        return dp[n][m];
    }
    public static void main(String[] args) {
        int nums[] = {50,3,10,7,40,80};
        System.out.println(lengthOfLISTab(nums)); 
    }
}