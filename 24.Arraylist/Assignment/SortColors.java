// // Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

// // We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

// // You must solve this problem without using the library's sort function.
// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]

class Solution {
    public void sortColors(int[] nums) {
        
        // Arrays.sort(nums); //can be solved easily using JCF
        //Selection sort(Brute)
        // for(int turn = 0 ; turn < nums.length -1 ; turn++){
        //     int minPos = turn ;
        //     for(int i = turn +1 ; i<nums.length ;i++){
        //         if(nums[minPos] > nums[i]){
        //             minPos = i;
        //         }
        //     }
        //     //swap
        //     int temp = nums[minPos];
        //     nums[minPos] = nums [turn];
        //     nums[turn] = temp;
        // } 

        //flag algo
        int n = nums.length;
        int low = 0 , mid =0 , high = n-1;
        while(mid <= high){
            if(nums[mid]  == 0 ){
            //swap mid and low
            int temp = nums[mid];
            nums[mid] = nums[low];
            nums[low] = temp;
            low++;
            mid++;
        }
        else if(nums[mid] == 1){
            mid++;
        }
        else if(nums[mid] == 2){
            //swap mid and high
            int temp = nums[mid];
            nums[mid] = nums[high];
            nums[high] = temp;
            high--; 
        }
        }
        
    }
}