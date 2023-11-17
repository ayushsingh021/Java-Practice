class Solution {
    public static void swap(int nums[] , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void reverse(int nums[] , int start , int end){
        int i = start;
        int j = end ; 
        while( i<= j ){
            swap(nums , i , j );
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1) return;

        int i=nums.length-2;
        int j = nums.length -1;
    while(i >= 0 && nums[i]>= nums[j]){
        i--;
        j--;
    }
   

    if( i>= 0 ){
        j = nums.length-1;
        while(j>= 0 && nums[i] >= nums[j]) j--;
        swap(nums, i , j);
    }

    reverse( nums , i+1 , nums.length-1);

    }
}