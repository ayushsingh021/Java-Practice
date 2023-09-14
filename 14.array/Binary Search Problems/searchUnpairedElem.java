// You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

// Return the single element that appears only once.

// Your solution must run in O(log n) time and O(1) space.

 

// Example 1:

// Input: nums = [1,1,2,3,3,4,4,8,8]
// Output: 2
// Example 2:

// Input: nums = [3,3,7,7,10,11,11]
// Output: 10

class Solution {
    //bruet
    // public int singleNonDuplicate(int[] nums) {
    //     int n = nums.length;
    //     for(int i = 1 ; i< n-1 ; i++){
    //         if(nums[i-1] < nums[i] && nums[i] < nums[i+1]){
    //             return nums[i];
    //         }
    //     }
    //     //edge
    //     if(nums.length > 1){
    //          if(nums[0] < nums[1]){
    //         return nums[0];
    //     }else if(nums[n-2] < nums[n-1]){
    //         return nums[n-1];
    //     }
    //     }
       
    //     return 1;
    // }
        //optimal ---Binary Search
     public int singleNonDuplicate(int[] nums) {
       int n = nums.length;
       if(n ==1){
           return nums[0];
       }
       if(nums[0] < nums[1] ) return nums[0];
       if(nums[n-2] < nums[n-1] ) return nums[n-1];

       //bin swarch

        int si = 1;
        int ei = nums.length-2;
       while(si <= ei){
           int mid  = (si+ ei)/2;

           if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]  ){
               return nums[mid];
           }
           //left
           if(nums[mid] == nums[mid-1] && (mid%2 == 1) || (nums[mid] == nums[mid+1]) && (mid%2) ==0 ){
            si = mid +1;
           }else{
               ei = mid-1;
           }

       }
       return -1;
    }
}