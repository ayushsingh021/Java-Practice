import java.util.*;
public class findKey{
    //finding index of minElem
    public static int minSearch(int [] nums){
        int left=0;
        int right =nums.length-1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(mid >0 && nums[mid-1]> nums[mid]){
                return mid;
            }
            else if(nums[mid-1] <= nums[mid] && nums[mid]>= nums[mid+1] ){
                left+=1;
            }
            else{
                right=right-1;
            }
        }
        return left;
    }
    //binary search from a sorted array
    public static int searchElem(int nums[], int left , int right , int key){
         int l= left;
         int r=right;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid]==key){
                return mid;
            }
            //left
            else if(nums[mid]> key){
               r =mid-1;
            }
            //right
            else{
                l= mid+1;
            }
        }
        return -1;
    }
    //finding key  is partly sorted array
    public static int findKey(int nums[], int key){
        int min = minSearch(nums);
        if(key >= nums[min] && nums[nums.length-1]>=key){
            //key is in right sorted part
            return searchElem(nums, min, nums.length-1, key);
        }
        else{
            return searchElem(nums,0, min, key);
        }
    }
     public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int nums[]={4,5,6,7,0,1,2};
    int key =0;
   System.out.println(findKey(nums, key));
     System.out.println();
     sc.close();
    }
}