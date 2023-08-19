// A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

// For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
// Input: nums = [1,2,3]
// Output: [1,3,2]

class Solution {
    public static void reverseArr(int [] nums , int si ,int ei ){
        while(si < ei){
            //swap
             int temp = nums[si];
                nums[si] = nums[ei];
                nums[ei] = temp;
                si++;
                ei--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;
        //1. Finding the break point
        for(int i  = n-2; i>= 0 ; i--){
            if(nums[i] < nums[i+1]){
                idx = i;
                break;
            }
        }
        System.out.println(idx);

        if(idx == -1){
            reverseArr(nums, 0 , n-1);
        }
        else{  
            //2. Swaping with min from back
             for(int j = n-1 ; j > idx; j--){
             if(nums[j] > nums[idx]){     
                // swap
                int temp = nums[j];
                nums[j] = nums[idx];
                nums[idx] = temp;
                break;
                }
            }
            //3.reverse the remaining array
            reverseArr(nums , idx + 1 , n-1);
        }  
      
    }
}