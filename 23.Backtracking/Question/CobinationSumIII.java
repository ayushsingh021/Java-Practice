// Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

// Only numbers 1 through 9 are used.
// Each number is used at most once.
// Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

 

// Example 1:

// Input: k = 3, n = 7
// Output: [[1,2,4]]
// Explanation:
// 1 + 2 + 4 = 7
// There are no other valid combinations.
// Example 2:

// Input: k = 3, n = 9
// Output: [[1,2,6],[1,3,5],[2,3,4]]
// Explanation:
// 1 + 2 + 6 = 9
// 1 + 3 + 5 = 9
// 2 + 3 + 4 = 9
// There are no other valid combinations.

//take reject khandani tarika  --  with for loop (for reject)
class Solution {
    public static void solve(int idx , int target , int k , List<Integer> ds ,List<List<Integer>> ans){
    
        //base case 
            if(target == 0 && ds.size()==k){
                ans.add(new ArrayList<>(ds));
            }
            //Subsequence method ---- pattern -2 (recursion )////
            //with for loop template -- reject(for loop)
            for(int i = idx ; i < 10 ; i++){
                if(i > target){
                    //no need to cheak for other options
                    break;
                }
                //take --
                ds.add(i);
                solve(i +1 ,target - i, k ,ds ,ans);
                ds.remove(ds.size()-1);
            }


    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        // int dp[][] = new int[][];
        List<List<Integer>> ans = new ArrayList<>();
        solve(1 , n , k , new ArrayList<>() , ans);
        return ans;
    }
}