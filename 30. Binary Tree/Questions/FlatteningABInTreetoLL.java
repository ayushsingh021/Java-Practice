// Given the root of a binary tree, flatten the tree into a "linked list":

// The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
// The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 

// Example 1:


// Input: root = [1,2,5,3,4,null,6]
// Output: [1,null,2,null,3,null,4,null,5,null,6]


class Solution {

    public static void preOrder(TreeNode root , ArrayList<TreeNode> nodesVal ){
        if(root == null){
            return;
        }

        nodesVal.add(root);
        preOrder(root.left , nodesVal);
        preOrder(root.right , nodesVal) ;
    }

    public static TreeNode solve(TreeNode root , ArrayList<TreeNode> nodesVal){
        TreeNode prev = root;
        
        for(int i = 1 ; i < nodesVal.size() ; i++){
            root.right = nodesVal.get(i);
            root.left = null;
            root = root.right;
        }

        return prev;

    }

    public void flatten(TreeNode root) {
        ArrayList<TreeNode> nodesVal = new ArrayList<>();
        preOrder(root , nodesVal);

        root = solve( root , nodesVal);
    }
}