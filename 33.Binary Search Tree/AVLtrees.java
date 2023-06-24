public class AVLtrees {
    

    static class TreeNode{
        int data;
        int height;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data = data;
            this.height = 1;
        }
    }

    public static TreeNode root;
    
    //height
    public static int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return root.height;
    }
    
    //preOrder
    public static void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    } 

    //Get Balance factor of node
    public static int getBalance(TreeNode root){
        if(root == null){
            return 0;
        }

        return height(root.left) - height(root.right);
    }

    public static TreeNode insert(TreeNode root , int key){
        if(root == null){
            return new TreeNode(key);
        }

        if(key < root.data){
            root.left = insert(root.left, key);
        }
        else if(key > root.data ){
            root.right = insert(root.right, key);
        }
        else{
        return root;   //duplicate keys are not allowed
        }
        //Update root height
        root.height = 1  + Math.max(height(root.left), height(root.right));

        //Calc root's balance factor
        int bf = getBalance(root);

        //left left case 
        if( bf > 1 && key < root.left.data){
            return rightRotate(root);
        }
        //right right case
        if(bf < -1  && key > root.right.data){
            return leftRotate(root);
        } 

        //left right case
        if(bf > 1 && key > root.left.data){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        //right left case
        if(bf < -1 && key < root.right.data){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;  //return if AVL is balanced
    }
    
    //left rotate subtree rooted with x  
    public static TreeNode leftRotate(TreeNode x){
        TreeNode y = x.right;
        TreeNode T2 = y.left;
        //perform rotation
        y.left = x;
        x.right = T2;

        //Update height
        x.height = Math.max(height(x.left), height(x.right))+1;
        y.height = Math.max(height(y.left), height(y.right))+1;
        // return new root
        return y;
    }

    //right rotate subtree rooted with y
    public static TreeNode rightRotate(TreeNode y){
        TreeNode x = y.left;
        TreeNode T2 = x.right;

        //perform rotation
        x.right = y;
        y.left = T2;

         //Update height
        x.height = Math.max(height(x.left), height(x.right))+1;
        y.height = Math.max(height(y.left), height(y.right))+1;

        return x;

    }
    public static void main(String[] args) {
        
        root = insert(root , 10);
        root = insert(root , 20);
        root = insert(root , 30);
        root = insert(root , 40);
        root = insert(root , 50);
        root = insert(root , 25);

        //AVL Tree
    //       30
    //     /   \
    //    20   40
    //   /  \    \
    // 10  25   50
    preOrder(root);
    

    }
}
