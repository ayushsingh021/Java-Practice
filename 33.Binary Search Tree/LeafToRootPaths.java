import java.lang.reflect.Array;
import java.util.ArrayList;

public class LeafToRootPaths{
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
    public static void root2LeafPathPrint(TreeNode root , ArrayList<Integer> path){
        if(root == null){
            return;
        }
        
        path.add(root.val);
        if(root.left == null && root.right == null){
            //reached to leaf
            printPath(path);
        }
        root2LeafPathPrint(root.left, path);
        root2LeafPathPrint(root.right, path);

        path.remove(path.size()-1);
    }
    public static void printPath(ArrayList<Integer> path){
        for(int i = 0 ;  i <path.size() ; i++){
            System.out.print(path.get(i) + " -> ");
        }
        System.out.print("null");
        System.out.println();
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

        System.out.println();
        inOrder(root);
        System.out.println();
        root2LeafPathPrint(root , path);
    }
}

