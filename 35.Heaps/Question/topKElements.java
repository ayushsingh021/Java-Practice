// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

// Example 1:

// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]
// Example 2:

// Input: nums = [1], k = 1
// Output: [1]
 





class Solution {

    static class Pair implements Comparable<Pair>{ //overridding
        int val;
        int freq;

        public Pair(int val, int freq){
            this.val = val;
            this.freq = freq;
        }
        @Override
        public int compareTo(Pair p2){
            return p2.freq - this.freq; // Dececnding
           
        }

    }
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt= 0 ;
        int i = 0,j=0;
        int n = nums.length;
        int arr[] = new int[k];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        while(i < n && j < n){
            if(nums[i] == nums[j]){
                cnt++;
                j++;
            }else{
                //store cnt
                pq.add(new Pair(nums[i] , cnt));
                cnt = 0;
                i=j;
            } 
        }
        if(cnt != 0){
            pq.add(new Pair(nums[i] , cnt));
        }
        for(int l = 0 ; l <k ;l++){
            arr[l] = pq.remove().val;
        }
        return arr;
    }
}