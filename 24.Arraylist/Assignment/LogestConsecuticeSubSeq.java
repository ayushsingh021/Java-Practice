// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

// You must write an algorithm that runs in O(n) time.
// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.


class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        // for(int i = 0 ; i < nums.length ; i ++){
        //     System.out.print(nums[i] + " ");
        // }
       int ans = 1;
       int count = 0;
       int lastSmaller = Integer.MIN_VALUE;
       for(int i = 0 ; i  < nums.length ; i++){
           int curr = nums[i];
           if(lastSmaller == curr-1 ){
               count++;
               lastSmaller = curr;
           }
           else if(curr != lastSmaller){
               count = 1 ;
               lastSmaller = curr;
           }
           ans = Math.max(ans, count);
       }
       return ans;
       
    }
}