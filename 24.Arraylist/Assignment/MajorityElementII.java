// // Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

// Input: nums = [3,2,3]
// Output: [3]

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int  i = 0 ; i < n ; i ++){
            int num = nums[i];
            if(map.containsKey(num)){
                //no already there
                //map.get(num) -- returns its previous value
                map.put(num , map.get(num) +1);
            }else{
                map.put(num , 1);
            }
        }

        //iterate
        Set<Integer> keys = map.keySet();
        //foreach loop
        List<Integer> ans = new ArrayList<>();
        for(Integer k : keys){
            if(map.get(k) > (n/3)){
                ans.add(k);
            }
        }
        return ans;
    }
}