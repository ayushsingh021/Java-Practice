// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

// If target is not found in the array, return [-1, -1].

// You must write an algorithm with O(log n) runtime complexity.

 

// Example 1:

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
// Example 2:

// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]
// Example 3:

// Input: nums = [], target = 0
// Output: [-1,-1]
 

// Constraints:

// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// nums is a non-decreasing array.
// -109 <= target <= 109


//Good Binary Search ques tion of using binary search in parts 
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lo = 0 ;
        int hi = nums.length-1;
        int ind = -1;
        while(lo <= hi ){
            int mid = (lo+hi)/2;
            if(nums[mid]  == target){
                ind = mid;
                break;
            }
            else if(nums[mid]  > target){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }

        int ans[] = new int[2];
        if(ind == -1){
            ans[0] = -1;
            ans[1]= -1;
            return ans;
        }
        //search in left side for min idtarget
        int l = 0 ; 
        int r = ind;
        while(l < r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                if(mid > 0 && nums[mid-1] == target){
                     r = mid-1;
                }
                else{
                    l = mid;
                    break;
                }
            }else{//cheak in right
                l = mid+1;
            }
        }
        ans[0] = l;

        //cheak in right part for matarget ind
        l = ind;
        r = nums.length-1;

        while(l < r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                if(mid < nums.length-1 && nums[mid+1] == target){
                     l = mid+1;
                }
                else{
                    r = mid;
                    break;
                }
            }else{//cheak in left
                r = mid-1;
            }
        }
        ans[1] = r;
        return ans;
    }
}