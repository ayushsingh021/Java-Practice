// You are given a 0-indexed integer array nums. You have to find the maximum sum of a pair of numbers from nums such that the maximum digit in both numbers are equal.

// Return the maximum sum or -1 if no such pair exists.

 

// Example 1:

// Input: nums = [51,71,17,24,42]
// Output: 88
// Explanation: 
// For i = 1 and j = 2, nums[i] and nums[j] have equal maximum digits with a pair sum of 71 + 17 = 88. 
// For i = 3 and j = 4, nums[i] and nums[j] have equal maximum digits with a pair sum of 24 + 42 = 66.
// It can be shown that there are no other pairs with equal maximum digits, so the answer is 88.
// Example 2:

// Input: nums = [1,2,3,4]
// Output: -1
// Explanation: No pair exists in nums with equal maximum digits.

class Solution {
    //better sol
    public static int maxDig(int num) {
        int max = Integer.MIN_VALUE;
        while (num > 0) {
            int dig = num % 10;
            if (dig > max) {
                max = dig;
            }
            num /= 10;
        }
        return max;
    }

    public int maxSum(int [] nums) {
        Map<Integer, PriorityQueue<Integer>> mp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            int maxDigit = maxDig(value);

            if (!mp.containsKey(maxDigit)) {
                mp.put(maxDigit, new PriorityQueue<>(Collections.reverseOrder()));
            }

            mp.get(maxDigit).add(value);
        }

        int sum = -1;

        for (int i = 0; i < 10; i++) {
            if (mp.containsKey(i)) {
                int temp = 0;

                temp += mp.get(i).poll();

                if (!mp.get(i).isEmpty()) {
                    temp += mp.get(i).poll();
                    if (sum < temp) {
                        sum = temp;
                    }
                }
            }
        }

        return sum;
    }
}


//optimal sol 
// class Solution {
//     public int maxSum(int[] nums) {
//         int maxd[]=new int[10];
//         int sum=-1;
//         for(int i=0;i<nums.length;i++){
//             int max=maxdigit(nums[i]);
//             if(maxd[max]!=0){
//                 sum=Math.max(sum,maxd[max]+nums[i]);
//             }
//             maxd[max]=Math.max(maxd[max],nums[i]);
//         }
//         return sum;
//     }
//     public static int maxdigit(int n){
//         int max=0;
//         while(n>0){
//             int p=n%10;
//             max=Math.max(max,p);
//             n=n/10;
//         }
//         return max;
//     }
// }