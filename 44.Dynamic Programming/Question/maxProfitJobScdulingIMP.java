// We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

// You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.

// If you choose a job that ends at time X you will be able to start another job that starts at time X.

 

// Example 1:



// Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
// Output: 120
// Explanation: The subset chosen is the first and fourth job. 
// Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
// Example 2:



// Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
// Output: 150
// Explanation: The subset chosen is the first, fourth and fifth job. 
// Profit obtained 150 = 20 + 70 + 60.
// Example 3:



// Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
// Output: 6
 

// Constraints:

// 1 <= startTime.length == endTime.length == profit.length <= 5 * 104
// 1 <= startTime[i] < endTime[i] <= 109
// 1 <= profit[i] <= 104



class Solution {
    public static int nextIndexDoableJob(int arr[][] , int l , int currJobEnd){
        int r = arr.length-1;
        //binary search for obtimized cuz sorted arr
        int result = arr.length+1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(arr[mid][0] >= currJobEnd){//nextJobstart is greter then currEnd so not overlapping we can do that job
            result = mid;
            r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return result;

    }
    public static int solve(int arr[][] , int i ,int dp[]){
        if(i >= arr.length) return 0;

    int next = nextIndexDoableJob(arr, i+1 ,arr[i][1]); //{array , low , targetIndex(endTofCurrJob) }
        if(dp[i] != -1){
            return dp[i];
        }
        int taken = arr[i][2] + solve(arr, next,dp);
        int notTaken = solve(arr, i+1,dp);

        return dp[i] = Math.max(taken ,notTaken);
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int arr[][] = new int[n][3];
        for(int i = 0 ; i <  n ; i++){
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }

        //sort using lambda function -- wrt startTime; 
        Arrays.sort(arr , Comparator.comparing( o -> o[0]));  //chotot theke boro ascending order
        int dp[] = new int[50001];
        Arrays.fill(dp , -1);

        return solve(arr, 0 ,dp);
    }
}
