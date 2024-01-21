
class Solution {
    public static int solve(TreeNode root , int minV , int maxV){
        if(root == null){
            return Math.abs(minV - maxV);
        }
        maxV = Math.max(maxV , root.val);
        minV = Math.min(minV , root.val);

        int leftSide = solve(root.left , minV ,maxV);
        int rightSide = solve(root.right , minV ,maxV);

        return Math.max(leftSide , rightSide);
         
    }
    public int maxAncestorDiff(TreeNode root) {
        return solve(root, root.val , root.val);
    }
}