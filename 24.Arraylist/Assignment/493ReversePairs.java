// //Very IMP QUES

// Given an integer array nums, return the number of reverse pairs in the array.

// A reverse pair is a pair (i, j) where:

// 0 <= i < j < nums.length and
// nums[i] > 2 * nums[j].

// Input: nums = [1,3,2,3,1]
// Output: 2
// Explanation: The reverse pairs are:
// (1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
// (3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1

//mergeSort Logic

class Solution {
    // static int count  = 0;
    public static int getPairs(int arr[], int si , int mid, int ei){
        int count= 0;
        int right = mid+1;
        for(int i = si ; i <=mid ; i++){
            while(right <= ei && arr[i] > 2*(long)arr[right]) right++;
            count = count+ (right - (mid+1));
            
        }
        return count;
    }
    public static int mergeSort(int arr[], int si, int ei){
        int count = 0 ;
        //base case
        if(si >= ei){
            return count;
        }
        //kaam
        // int mid = si + (ei-si)/2;
        int mid = (si + ei)/2;

        count += mergeSort(arr, si, mid);//leftpart
        count += mergeSort(arr, mid+1, ei);//rightpart
        count += getPairs(arr,si, mid, ei);
        merge(arr, si,mid,ei); 
        return count;
    }
    public static void merge(int arr[],int si,int mid, int ei){
        //left(0,3)=4  rignt(4,6)=3 total =7 (6-0+1)
        int temp[] = new int [ei - si + 1];  //same as the forula f-i+1
        int i = si; //iterator for left part
        int j = mid+1;//iterator for right part
        int k =  0; //iterator for temp array

        //left and right sorted part getting merged through iterator model
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        //left part ke leftovers jo add karna
        while(i <= mid){
            temp[k++]=arr[i++];
        }

        //right part ke leftovers jo add karna
        while(j <= ei){
            temp[k++]= arr[j++];
        }
        //copying temp array to original array
        for(k=0 , i = si ; k < temp.length ; k++, i++){
            arr[i]=temp[k];
        }

    }
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0 , nums.length-1);
    }
}