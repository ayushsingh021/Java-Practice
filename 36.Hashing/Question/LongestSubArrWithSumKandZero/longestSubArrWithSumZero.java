// Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

// Example 1:

// Input:
// N = 8
// A[] = {15,-2,2,-8,1,7,10,23}
// Output: 5
// Explanation: The largest subarray with
// sum 0 will be -2 2 -8 1 7.
// Your Task:
// You just have to complete the function maxLen() which takes two arguments an array A and n, where n is the size of the array A and returns the length of the largest subarray with 0 sum.

// Expected Time Complexity: O(N).
// Expected Auxiliary Space: O(N).

class GfG
{
    int maxLen(int arr[], int n)
    {   
        int i = -1;
        int sum = 0;
        HashMap<Integer , Integer> hm = new HashMap<>();
        hm.put(sum , i);
        int maxLen = Integer.MIN_VALUE;
        
        while(i < arr.length-1){
            i++;
            sum += arr[i];
            if(!hm.containsKey(sum)){
                hm.put(sum , i);
            }else{
                int len =  i - hm.get(sum);
                if(len > maxLen){
                maxLen = len;
                }
            }
        }
        if(maxLen == Integer.MIN_VALUE){
            return 0;
        }
        
        return maxLen;
    }
}