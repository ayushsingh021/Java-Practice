// You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.

// Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.

 

// Example 1:

// Input: nums = [1,1,4,2,3], x = 5
// Output: 2
// Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
// Example 2:

// Input: nums = [5,6,7,8,9], x = 4
// Output: -1
// Example 3:

// Input: nums = [3,2,20,1,1,3], x = 10
// Output: 5
// Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
 

//this question is  a application of finding longestSubArr of target  ( totalArrSum - x)

//Optiamal Solution  -- O(n)  
class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        HashMap<Integer , Integer>hm = new HashMap<>();
        int sum = 0 ;
        hm.put(0,-1); //edge case handle 
        for(int i = 0 ; i < n  ; i ++){
            sum += nums[i];
            hm.put(sum , i);
        }
        if(sum < x){
            return -1;
        } 
        int remSum = sum - x; // target sum of the longest subArr
        

        int longestSubArr = Integer.MIN_VALUE;

        sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum += nums[i];
            int findSum = sum - remSum;
            if(hm.containsKey(findSum)){
                int idx = hm.get(findSum);
                longestSubArr = Math.max(longestSubArr , i-idx);
            }
        }

        return longestSubArr == Integer.MIN_VALUE ? -1 : (n - longestSubArr); 
    }
}

//Pick and Not Pick Approach -- (Using recursion) -- not using longestSubArr --> rahter using left + right pick approach
class Solution {
    static int minCount ;
    
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        minCount = Integer.MAX_VALUE;
        int count = 0;
        
        solve(nums , x, 0, 0, n-1);
        
        if(minCount == Integer.MAX_VALUE) 
            return -1;
        
        return minCount;
    }
    public static void solve(int[] nums, int remain, int count, int i, int j){
        
        if(remain == 0) {
            minCount = Math.min(minCount, count);
            return;
        }
        else if(remain<0 || i>j || count>=minCount ) 
            return;
        else{
            solve(nums, remain-nums[i], count+1, i+1, j);
            solve(nums, remain-nums[j], count+1, i, j-1);
        }
    }
}