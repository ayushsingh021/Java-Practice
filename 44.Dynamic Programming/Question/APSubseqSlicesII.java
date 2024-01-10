// Given an integer array nums, return the number of all the arithmetic subsequences of nums.

// A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

// For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are arithmetic sequences.
// For example, [1, 1, 2, 5, 7] is not an arithmetic sequence.
// A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.

// For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
// The test cases are generated so that the answer fits in 32-bit integer.

 

// Example 1:

// Input: nums = [2,4,6,8,10]
// Output: 7
// Explanation: All arithmetic subsequence slices are:
// [2,4,6]
// [4,6,8]
// [6,8,10]
// [2,4,6,8]
// [4,6,8,10]
// [2,4,6,8,10]
// [2,6,10]
// Example 2:

// Input: nums = [7,7,7,7,7]
// Output: 16
// Explanation: Any subsequence of this array is arithmetic.
 

// Constraints:

// 1  <= nums.length <= 1000
// -231 <= nums[i] <= 231 - 1



class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        HashMap<Integer , Integer>[] hm = new HashMap[nums.length] ; //array of hashmap
        //initailise
        for(int i = 0 ; i < nums.length ; i++){
            hm[i] = new HashMap<>();
        }
        int ans = 0;
        for(int i = 1; i < nums.length ; i++){
            for(int j = 0 ; j <i ; j++){
                long cd = (long)nums[i] - (long)nums[j];
                //if limit is out of the Integer rnage
                if(cd <= Integer.MIN_VALUE || cd >= Integer.MAX_VALUE){
                    continue;
                }

                int apsEndingatJ = hm[j].getOrDefault((int)cd , 0);
                int apsEndingatI = hm[i].getOrDefault((int)cd , 0);

                ans += apsEndingatJ;
                hm[i].put((int)cd ,apsEndingatJ + apsEndingatI +1);

            }
        }

        return ans;
    }
}