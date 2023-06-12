import java.util.*;
public class KthAncestorofNode {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        //constructor
        TreeNode(int data){
            this.val =data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int idx = -1;
        public static TreeNode binaryTreeBuilder(int nodes[]){
            idx++;
            //base case
            if(nodes[idx] == -1){
                return null;
            }

            TreeNode newNode = new TreeNode(nodes[idx]);
            newNode.left = binaryTreeBuilder(nodes);
            newNode.right = binaryTreeBuilder(nodes);

            return newNode;
        }   

        public static int kAncestor(TreeNode root , int n ,int k ){
            if(root == null){
                return -1;
            }
            if(root.val == n){
                return 0;
            }

            int leftDist = kAncestor(root.left, n, k);
            int rightDist = kAncestor(root.right, n, k);
            if(leftDist == -1 && rightDist == -1){
                return -1;
            }
            int max = Math.max(leftDist, rightDist);
            if(max +1  == k){
                System.out.println(root.val);
            }

            return max+1;
        }
      
    
        
    
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        BinaryTree tree = new BinaryTree();  //object creation
        TreeNode root = tree.binaryTreeBuilder(nodes);
        int n=5, k =2;
        System.out.println(tree.kAncestor(root, n, k));
    
}
}