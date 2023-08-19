// Given an array nums of size n, return the majority element.

// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
// Input: nums = [2,2,1,1,1,2,2]
// Output: 2

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0 ; i < nums.length ;i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i] , hm.get(nums[i]) + 1);
            }else{
                hm.put(nums[i], 1);
            }
        }
        System.out.println(hm);
        Set<Integer> keys = hm.keySet();
        for (Integer k : keys){
            if(hm.get(k) > (nums.length)/2){
                return k;
            }
        }

        return 0;
        
    }
}