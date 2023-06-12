import java.util.*;
public class MinDistBtwNodes {
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

      
       public static int lcaDist(TreeNode root , int n){
        if(root == null){
            return -1;
        }
        if(root.val == n){
            return 0;
        }

        int leftDist = lcaDist(root.left,n);
        int rightDist = lcaDist(root.right,n);

        if(leftDist == -1 && rightDist == -1){
            return -1;
        }
        else if(leftDist == -1){
            return rightDist+1;
        }else{
            return leftDist+1;
        }

       }
        public static int minDist(TreeNode root , int n1, int n2){
            TreeNode lca = lca2(root, n1, n2);
            
            int dist1 = lcaDist(lca ,n1);
            int dist2 = lcaDist(lca, n2);
            return dist1 + dist2;


        }
            //lca calculate
            public static TreeNode lca2(TreeNode root , int n1 , int n2){
                //basecase
                if(root == null || root.val == n1 || root.val ==n2){
                    //eiherr root is null so exist hi nhi karte nodes OR we found the n1/n2 at that root so return that root
                    return root;
                }

                TreeNode leftLca = lca2(root.left, n1, n2);
                TreeNode rightLca = lca2(root.right, n1, n2);

                if(leftLca == null){
                    //rightLca has some valid ans and consists n1 and n2
                    return rightLca;
                }
                if(rightLca== null){
                    return leftLca;
                }

                return root;
            }
        
    
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        BinaryTree tree = new BinaryTree();  //object creation
        TreeNode root = tree.binaryTreeBuilder(nodes);
        int n1 = 4, n2 =6;
        System.out.println(tree.minDist(root, n1, n2));
    }
    
}
