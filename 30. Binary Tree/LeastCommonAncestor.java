import java.util.ArrayList;

public class LeastCommonAncestor {
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

        public static boolean getPath(TreeNode root , int n , ArrayList<TreeNode> path){
            if(root== null){
                return false;
            }
            path.add(root);
            if(root.val == n){
                return true;
            }
        
            boolean foundLeft = getPath(root.left , n  , path);
            boolean foundRight = getPath(root.right , n  , path);
            if(foundLeft || foundRight){
                return true;
            }
            path.remove(path.size()-1);
            return false;
        
        }
        public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
                ArrayList<TreeNode> path1 = new ArrayList<>();
                ArrayList<TreeNode> path2 = new ArrayList<>();
        
                getPath(root, p , path1);
                getPath(root, q , path2);
                int i = 0;
                for( ; i<path1.size() && i< path2.size() ; i++){
                    if(path1.get(i) != path2.get(i)){
                        break;
                    }
                }
                //last common value must be at (i-1)th idx 
                TreeNode lca = path1.get(i-1);
            return lca;
            }

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
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();  //object creation
        TreeNode root = tree.binaryTreeBuilder(nodes) ; //method call kia Binary tree ka
        int n1 =4, n2= 6;
        System.out.println(tree.lowestCommonAncestor(root,n1,n2).val );
        System.out.println(tree.lca2(root,n1,n2).val );
    }
}
