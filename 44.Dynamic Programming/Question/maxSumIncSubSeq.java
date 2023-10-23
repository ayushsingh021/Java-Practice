// Given an array of n positive integers. Find the sum of the maximum sum subsequence of the given array such that the integers in the subsequence are sorted in strictly increasing order i.e. a strictly increasing subsequence. 

// Example 1:

// Input: 
// N = 5, arr[] = {1, 101, 2, 3, 100} 
// Output: 
// 106
// Explanation:
// The maximum sum of a increasing sequence is obtained from {1, 2, 3, 100},

class Solution
{
	public int maxSumIS(int arr[], int n)  
	{  
	       int T[] = new int[arr.length];

        for (int i = 0; i < T.length; i++) {
            T[i] = arr[i];
        }

        for(int i=1; i < T.length; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){
                    T[i] = Math.max(T[i], T[j] + arr[i]);
                }
            }
        }

        int max = T[0];
        for (int i=1; i < T.length; i++){
            if(T[i] > max){
                max = T[i];
            }
        }
        return max;
	}  
}