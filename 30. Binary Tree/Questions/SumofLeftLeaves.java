// Given the root of a binary tree, return the sum of all left leaves.

// A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.

 

// Example 1:


// Input: root = [3,9,20,null,null,15,7]
// Output: 24
// Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
// Example 2:

// Input: root = [1]
// Output: 0
 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static int sumNode(TreeNode root , TreeNode par){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            if(par != null && par.left == root){
                return root.val;
            }
        }

        int leftVal = sumNode(root.left , root);
        int rightVal = sumNode(root.right, root);

        return leftVal + rightVal;
    }
    public int sumOfLeftLeaves(TreeNode root) {
        return sumNode(root , null);
    }
}