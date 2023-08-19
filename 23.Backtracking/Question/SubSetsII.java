// Given an integer array nums that may contain duplicates, return all possible 
// subsets
//  (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.

// Input: nums = [1,2,2]
// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
class Solution {
    public void findSubsets(int idx , int[] nums, List<Integer> ds ,List<List<Integer>> ansList ){
        ansList.add(new ArrayList<>(ds)); 
        
        for(int i = idx;i<nums.length;i++) {
            if(i!=idx && nums[i] == nums[i-1]) {
                continue;
            }
            ds.add(nums[i]); 
            findSubsets(i+1, nums, ds, ansList); 
            ds.remove(ds.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();
        findSubsets(0 , nums , new ArrayList<>() , ansList);
        return ansList;
    }
}