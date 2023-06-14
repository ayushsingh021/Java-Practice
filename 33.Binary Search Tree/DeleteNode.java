public class DeleteNode {
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
  
    
    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }
        if(root.val > key ){
            root.left =  deleteNode(root.left , key);
        }
        else if(root.val < key){
            root.right = deleteNode(root.right , key);
        }
        else{  //found
        //case 1- no child(leave node is key)
        if(root.right == null && root.left == null){
            return null;
        }

        //case 2 -One child
        if(root.left == null){
            return root.right;
        }
        else if(root.right == null){
            return root.left;
        }

        //case 3 -- Two child (InorderSccessor)
        TreeNode IS = inOrderSuccessorFind(root.right);
        root.val = IS.val;
        root.right = deleteNode(root.right , IS.val);
        

       }

    return root;
    }
    public static TreeNode inOrderSuccessorFind(TreeNode root){
        if(root.left != null){
            root = root.left;
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

    

    public static void main(String[] args) {
        // int value[] = {5,1,3,4,2,7};
        int value[] = {8,5,3,1,4,6,10,11,14};
        TreeNode root = null;
        for(int  i = 0 ; i < value.length ; i++){
           root = insert(root, value[i]);
        }
        inOrder(root);

        deleteNode(root,5);
System.out.println();
        inOrder(root);
    }
}
