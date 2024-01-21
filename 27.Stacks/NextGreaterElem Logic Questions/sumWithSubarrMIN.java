// 907. Sum of Subarray Minimums
// Solved
// Medium
// Topics
// Companies
// Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

// Example 1:

// Input: arr = [3,1,2,4]
// Output: 17
// Explanation: 
// Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
// Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
// Sum is 17.
// Example 2:

// Input: arr = [11,81,94,43,3]
// Output: 444

// Constraints:

// 1 <= arr.length <= 3 * 104
// 1 <= arr[i] <= 3 * 104

class Solution {
    public static void nextSmallerLeft(int[] heights, int[] arr) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!s.isEmpty() && heights[s.peek()] > heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                arr[i] = -1;
            } else {
                arr[i] = s.peek();
            }
            s.push(i);
        }

    }

    public static void nextSmallerRight(int[] heights, int[] arr) {
        Stack<Integer> s = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                arr[i] = heights.length;
            } else {
                arr[i] = s.peek();
            }
            s.push(i);
        }

    }

    public int sumSubarrayMins(int[] arr) {
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];
        nextSmallerLeft(arr, nsl);
        nextSmallerRight(arr, nsr);
        long ans = 0;
        int MOD = 1000000007;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(nsl[i] + " " + i + " " + nsr[i]);
            long r = nsr[i] - i;
            long l = i - nsl[i];
            long mul = r * l;
            long sumTotal = arr[i] * mul;
            ans = (ans + sumTotal) % MOD;
        }

        return (int) ans;

    }
}