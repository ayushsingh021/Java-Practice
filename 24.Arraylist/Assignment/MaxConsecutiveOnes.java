// Given a binary array nums, return the maximum number of consecutive 1's in the array.
// Input: nums = [1,1,0,1,1,1]
// Output: 3
// Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = Integer.MIN_VALUE;
        int count =  0;
        int i = 0 ;
        for(int  j = 0 ; j < nums.length ; j++){
            if(nums[i] == 1 && nums[i] == nums[j]){
                count ++ ;
            }else{
                count = 0;
                i = j+1;
            }
                maxCount = Math.max(maxCount , count);

        }
        return maxCount;
    }
}