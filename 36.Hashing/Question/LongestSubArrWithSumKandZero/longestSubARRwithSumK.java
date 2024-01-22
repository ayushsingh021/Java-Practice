// Given an array containing N integers and an integer K., Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value K.

// Example 1:

// Input :
// A[] = {10, 5, 2, 7, 1, 9}
// K = 15
// Output : 4
// Explanation:
// The sub-array is {5, 2, 7, 1}.
// Example 2:

// Input : 
// A[] = {-1, 2, 3}
// K = 6
// Output : 0
// Explanation: 
// There is no such sub-array with sum 6.

class Solution {

    // Function for finding maximum and value pair
    public static int lenOfLongSubarr(int arr[], int n, int K) {
        int i = -1;
        int sum = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(sum, i);
        int maxLen = Integer.MIN_VALUE;

        while (i < arr.length - 1) {
            i++;
            sum += arr[i];
            if (!hm.containsKey(sum)) {
                hm.put(sum, i);
            }
            if (hm.containsKey(sum - K)) {
                int len = i - hm.get(sum - K);
                if (len > maxLen) {
                    maxLen = len;
                }
            }
        }
        if (maxLen == Integer.MIN_VALUE) {
            return 0;
        }

        return maxLen;
    }

}
