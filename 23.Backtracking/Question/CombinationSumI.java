// Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

// The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
// frequency
//  of at least one of the chosen numbers is different.

// The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]
// Explanation:
// 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
// 7 is a candidate, and 7 = 7.
// These are the only two combinations.


class Solution {
    public void helper(List<List<Integer>>  ans,List<Integer> ds ,int[] candidates,int target,int idx){
        if(idx == candidates.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
         /// Pick and Not pick method (patter 1) -- recursion //
        if(candidates[idx] <= target){
          ds.add(candidates[idx]);
          helper(ans,ds,candidates,target - candidates[idx] , idx);
          ds.remove(ds.size()-1);
        }
        helper(ans ,ds, candidates , target , idx+1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Arrays.sort(candidates);
         List<List<Integer>>  ans = new ArrayList<>();
         helper(ans ,new ArrayList<>(), candidates , target , 0);
         return ans;  
    }
}