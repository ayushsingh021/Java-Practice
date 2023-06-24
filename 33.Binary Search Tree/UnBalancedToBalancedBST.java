import java.util.ArrayList;

public class UnBalancedToBalancedBST {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.val =data;
            this.left =null;
            this.right = null;
        }
    }
    public static void preOrder(TreeNode root){
        if(root == null){
            return; 
        }
        System.out.print( root.val + " ");
        preOrder(root.left);
       
        preOrder(root.right);
    }
    public static void inOrder(TreeNode root , ArrayList<Integer> list){
        if(root == null){
            return; 
        }
      
        inOrder(root.left , list);
        list.add(root.val);        
        inOrder(root.right, list);
    }

    public static TreeNode balacedBST(TreeNode root){
        //inorder seq
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);

        //sorted inorder to Balnced BST
        return inorderTobalacedBSTcreate(list, 0 ,list.size()-1);
      
    }
    public static TreeNode inorderTobalacedBSTcreate(ArrayList<Integer> list ,int si ,int ei){
        if(si>ei){
            return null;
        }
        int mid = (si + ei)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = inorderTobalacedBSTcreate(list, si, mid -1);
        root.right = inorderTobalacedBSTcreate(list, mid+1, ei);
        
        return root;
    }

    public static void main(String[] args) {
            //        8
            //       / \
            //      6   10
            //     /      \
            //    5         11
            //   /           \
            //  3             12
            //Le - man Tree create :))
            TreeNode root = new TreeNode(8);
            root.left = new TreeNode(6);
            root.left.left = new TreeNode(5);
            root.left.left.left = new TreeNode(3);

            root.right = new TreeNode(10);
            root.right.right = new TreeNode(11);
            root.right.right.right = new TreeNode(12);
            
           root = balacedBST(root);
           preOrder(root);
        }
}
