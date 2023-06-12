import java.util.*;
public class TransformToSumTree{
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

        public static int sumTree(TreeNode root){
            if(root == null){
                return 0;
            }
            
            int leftChild = sumTree(root.left);
            int rightChild = sumTree(root.right);

            int dataOld = root.val;
            int newLeft = root.left == null ? 0 : root.left.val;
            int newRight = root.right == null ? 0 : root.right.val;

            root.val = leftChild + rightChild + newLeft + newRight;

            return dataOld;
        }

        public static void preOrder(TreeNode root){
            if(root == null){
                return;
            }
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    
        
    
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        BinaryTree tree = new BinaryTree();  //object creation
        TreeNode root = tree.binaryTreeBuilder(nodes);
        
        tree.sumTree(root);
        tree.preOrder(root);
    
}

    
}