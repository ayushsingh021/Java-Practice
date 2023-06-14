public class PrintInRange{
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

    public static void printRange(TreeNode root , int k1 ,int k2){
        if(root == null){
            return;
        }

        if(root.val >= k1 &&root.val <= k2 ){
            printRange(root.left, k1, k2);
            System.out.print( root.val + " ");
            printRange(root.right, k1, k2);
        }
        else if(root.val < k1){
            printRange(root.left, k1, k2);
        }
        else{
            printRange(root.right, k1, k2);
        }
    }

    

    public static void main(String[] args) {
        // int value[] = {5,1,3,4,2,7};
        int value[] = {8,5,3,1,4,6,10,11,14};
        TreeNode root = null;
        for(int  i = 0 ; i < value.length ; i++){
           root = insert(root, value[i]);
        }
        inOrder(root);

System.out.println();
        inOrder(root);
        System.out.println();
        printRange(root, 5, 14);
    }
}
