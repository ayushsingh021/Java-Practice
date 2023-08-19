// Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

class Solution {
    public static void helper(int[] nums ,List<List<Integer>> ans , List<Integer> ds , boolean[] vis){
        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(!vis[i]){
            ds.add(nums[i]);
            vis[i] = true;
            helper(nums, ans , ds , vis );
            ds.remove(ds.size()-1);
            vis[i] = false;
            }
           
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean vis[] = new boolean[nums.length];
        helper(nums, ans , new ArrayList<>() , vis);
        return ans;
    }
}