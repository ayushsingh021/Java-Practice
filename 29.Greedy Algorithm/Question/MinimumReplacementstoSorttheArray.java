// //Very Imp --- GOOGLE,SALESFORSE

// You are given a 0-indexed integer array nums. In one operation you can replace any element of the array with any two elements that sum to it.

// For example, consider nums = [5,6,7]. In one operation, we can replace nums[1] with 2 and 4 and convert nums to [5,2,4,7].
// Return the minimum number of operations to make an array that is sorted in non-decreasing order.

 

// Example 1:

// Input: nums = [3,9,3]
// Output: 2
// Explanation: Here are the steps to sort the array in non-decreasing order:
// - From [3,9,3], replace the 9 with 3 and 6 so the array becomes [3,3,6,3]
// - From [3,3,6,3], replace the 6 with 3 and 3 so the array becomes [3,3,3,3,3]
// There are 2 steps to sort the array in non-decreasing order. Therefore, we return 2.

// Learning
// https://github.com/MAZHARMIK/Interview_DS_Algo/blob/master/iPad%20PDF%20Notes/Leetcode-2366-Minimum%20Replacements%20to%20Sort%20the%20Array.pdf
class Solution {
    public long minimumReplacement(int[] nums) {
        long oprn = 0;

        int n = nums.length;
        for(int i = n-2 ; i>= 0 ; i--){
            if(nums[i] < nums[i+1]){
                continue;
            }

            int parts = nums[i]/nums[i+1];
            if(nums[i] % nums[i+1] != 0){
                parts++;
            }
            oprn += (parts-1);
            nums[i] = nums[i]/parts;
        }
        return oprn;
    }
}