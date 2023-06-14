public class BSTBuild{

    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
     public static TreeNode insert(TreeNode root ,int value){
        
        if(root == null){
            root = new TreeNode(value);
            return root;
        }
        if(root.data > value){ //leftsubtree me dalegi
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
        System.out.print(root.data + " " );
        inOrder(root.right);
    }

    public static void main(String[] args) {
        int value[] = {5,1,3,4,2,7};
        TreeNode root = null;
        for(int  i = 0 ; i < value.length ; i++){
           root = insert(root, value[i]);
        }
        inOrder(root);
      
    }
}