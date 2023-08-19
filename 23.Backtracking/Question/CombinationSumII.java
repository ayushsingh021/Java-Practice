// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

// Each number in candidates may only be used once in the combination.

// Note: The solution set must not contain duplicate combinations.
// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output: 
// [
// [1,1,6],
// [1,2,5],
// [1,7],
// [2,6]
// ]

class Solution {
    public void helper(int idx ,int[] candidates, int target, List<Integer>ds , List<List<Integer>> ans ){
        //base case
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            //Subsequence method ---- pattern -2 (recursion )////
            for(int i = idx ; i < candidates.length ; i++){
                if(i > idx && candidates[i] == candidates[i-1]){
                    //same element so isse nahi lena
                    continue;
                }
                if(candidates[i] > target){
                    //no need to cheak for other options
                    break;
                }
                ds.add(candidates[i]);
                helper(i +1 , candidates ,target - candidates[i], ds ,ans);
                ds.remove(ds.size()-1);
            }

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        helper(0 , candidates ,target , new ArrayList<>() , ans );
        return ans;
    }
}