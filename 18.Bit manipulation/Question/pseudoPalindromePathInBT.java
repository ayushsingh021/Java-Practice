
class Solution {

    public static int solve(TreeNode root, int val  , int ans[]){
       if(root == null){
           return 0;
       }
       val = val^(1<<root.val);
       int left = solve(root.left, val ,ans);
       int right = solve(root.right,val ,ans);
       if(left == 0 && right == 0){
          if( (val&(val-1)) == 0) {
              ans[0]++;
          }
       }
      
       return 10;
   }
   public int pseudoPalindromicPaths (TreeNode root) {
          
           int ans[] = new int[1];
           solve(root,0 ,ans);
       return ans[0];
       
   }
}