import java.util.*;
public class MirrorBST {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
            this.left=null;
            this.right =null;
        }
        
    }
    public static TreeNode insert(TreeNode root ,int value){
        
        if(root == null){
            root = new TreeNode(value);
            return root;
        }
        if(root.val > value){ //leftsubtree me dalegi
            root.left = insert(root.left, value);
        }else{ //rightSubtree medalegi
            root.right = insert(root.right, value);
        }
        return root;
     }
  
  
     public static void inOrder ( TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " " );
        inOrder(root.right);
    }
    public static TreeNode mirroringBST ( TreeNode root){
            if(root == null){
                return null;
            }
            TreeNode leftSub  = mirroringBST(root.left);
            TreeNode rightSub  = mirroringBST(root.right);

            root.left = rightSub;
            root.right = leftSub;
            return root;
    }


    public static void main(String[] args) {
        // int value[] = {5,1,3,4,2,7};
        int value[] = {8,5,3,1,4,6,10,11,14};
        ArrayList<Integer> path = new ArrayList<>(); 
        TreeNode root = null;
        for(int  i = 0 ; i < value.length ; i++){
           root = insert(root, value[i]);
        }
        inOrder(root);
        mirroringBST(root);
        System.out.println();
        inOrder(root);
        
    }
    
}
