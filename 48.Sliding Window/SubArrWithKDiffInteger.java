// 992. Subarrays with K Different Integers
// Given an integer array nums and an integer k, return the number of good subarrays of nums.

// A good array is an array where the number of different integers in that array is exactly k.

// For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
// A subarray is a contiguous part of an array.

 

// Example 1:

// Input: nums = [1,2,1,2,3], k = 2
// Output: 7
// Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
// Example 2:

// Input: nums = [1,2,1,3,4], k = 3
// Output: 3
// Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].


// Used Khandani template 


class Solution {
    //Khandani temaplate
    public int slidingWindow(int [] nums, int k){
        int i = 0; 
        int j = 0;
        int ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;

        while(j < n && i < n){
            hm.put(nums[j], hm.getOrDefault(nums[j] , 0)+1);
          
            while( hm.size() > k ){
                //Shiriking the window 
                  if(hm.get(nums[i]) == 1){
                        hm.remove(nums[i]);
                  }else{
                        hm.put(nums[i] , hm.get(nums[i])-1);
                  }
                  i++;
            }
            //for a window number of subarr ending at 'j' are -->  (j-i+1)
            // [2,3,1] -- > [2,3,1] , [3,1] , [1] --> if  j is at 2 idx  
            ans += (j-i+1);
            j++;
        }

        return ans;

    }
    public int subarraysWithKDistinct(int[] nums, int k) {
     
        return slidingWindow(nums , k ) - slidingWindow(nums, k-1);
    }
}