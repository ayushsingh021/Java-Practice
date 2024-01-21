// Given N numbers in an array, your task is to keep at most the top K numbers with respect to their frequency.

// In other words, you have to iterate over the array, and after each index, determine the top K most frequent numbers until that iteration and store them in an array in decreasing order of frequency. An array will be formed for each iteration and stored in an array of arrays. If the total number of distinct elements is less than K, then keep all the distinct numbers in the array. If two numbers have equal frequency, place the smaller number first in the array.

// Example 1:

// Input:
// N=5, K=4
// arr[] = {5, 2, 1, 3, 2} 
// Output: 
// 5 
// 2 5 
// 1 2 5 
// 1 2 3 5 
// 2 1 3 5 
// Explanation:
// Firstly there was 5 whose frequency
// is max till now. So resulting sequence is {5}.
// Then came 2, which is smaller than 5 but
// their frequencies are same so resulting sequence is {2, 5}.
// Then came 1, which is the smallest among all the
// numbers arrived, so resulting sequence is {1, 2, 5}.
// Then came 3 , so resulting sequence is {1, 2, 3, 5}
// Then again 2, which has the highest
// frequency among all numbers, 
// so resulting sequence {2, 1, 3, 5}.
// Example 2:

// Input:
// N=6, K=3
// arr[] = {2, 1, 2, 1, 2, 1} 
// Output: 
// 2 
// 1 2 
// 2 1 
// 1 2 
// 2 1
// 1 2
// Explanation:
// As total number of distinct values never
// exceeds 2, you have to return only those two
// values. In the case where frequency of 1 gets
// equal with the frequency of 2, you have to 
// keep 1 before 2 in the array.

class Solution {
    static class Pair implements Comparable<Pair> {
        int val;
        int freq;

        public Pair(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }

        @Override
        public int compareTo(Pair p2) {
            return p2.freq - this.freq == 0 ? this.val - p2.val : p2.freq - this.freq;
        }
    }

    public static ArrayList<ArrayList<Integer>> kTop(int[] arr, int N, int K) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(arr[0]);
        ans.add(list1);

        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(arr[0], 1);

        for (int i = 1; i < N; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);

            PriorityQueue<Pair> pq = new PriorityQueue<>();
            pq.add(new Pair(arr[i], hm.get(arr[i])));

            int cnt = K;

            HashSet<Integer> st = new HashSet<>();
            for (int j = i - 1; j >= 0; j--) {
                st.add(arr[i]);
                if (!st.contains(arr[j])) {
                    pq.add(new Pair(arr[j], hm.get(arr[j])));
                    st.add(arr[j]);
                }

            }

            ArrayList<Integer> list = new ArrayList<>();
            while (!pq.isEmpty() && cnt > 0) {
                list.add(pq.remove().val);
                cnt--;
            }
            ans.add(list);
        }

        return ans;

    }
}