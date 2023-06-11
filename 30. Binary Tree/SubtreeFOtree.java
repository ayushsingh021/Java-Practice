public class SubtreeFOtree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.val= data;
            this.left =null;
            this.right =null;
        }
    }
    static class BinaryTree{
        static int idx = -1;
        public static TreeNode binaryTreeBuiler(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            TreeNode newNode = new TreeNode(nodes[idx]);
            newNode.left = binaryTreeBuiler(nodes);
            newNode.right = binaryTreeBuiler(nodes);
            
            return newNode;
        }
    public static boolean isIdentical(TreeNode node , TreeNode subRoot){
        if(node == null && subRoot == null){
            return true;
        }
        else if(node == null || subRoot == null || node.val != subRoot.val){
            return false;
        }

        if(!isIdentical(node.left ,subRoot.left)){
            return false;
        }
        if(!isIdentical(node.right, subRoot.right)){
            return false;
        }
        return true;
    }
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
      if(root == null){
          return false;
      }
      if(root.val == subRoot.val){
          if(isIdentical(root,subRoot)){
              return true;
          }
      }
      
    //   boolean leftAns = isSubtree(root.left , subRoot);
    //   boolean rightAns = isSubtree(root.right , subRoot);
    //improvees speed
    return isSubtree(root.left , subRoot) || isSubtree(root.right , subRoot);
    }
    
}
public static void main(String[] args) {
  
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.binaryTreeBuiler(nodes);
        TreeNode subtreeRoot = new TreeNode(2);
         subtreeRoot.left = new TreeNode(4);      
         subtreeRoot.right = new TreeNode(5);
         
         System.out.println(tree.isSubtree(root, subtreeRoot));
    
}

}