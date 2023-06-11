public class DiameterOfBinTree {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data= data;
            this.left =null;
            this.right =null;
        }
    }
    static class BinaryTree{
        static int idx = -1;
        public static Node binaryTreeBuiler(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = binaryTreeBuiler(nodes);
            newNode.right = binaryTreeBuiler(nodes);
            
            return newNode;
        }
        public static int maxHeight(Node root){
            if(root  == null){
                return 0;
            }
            int lh = maxHeight(root.left);
            int rh =  maxHeight(root.right);
    
            int ht = Math.max(lh,rh) + 1;
      
            return ht;
    
        }
        public static int diameter(Node root){
            if(root == null){
                return 0;
            }

            int leftDiam = diameter(root.left);
            int lh = maxHeight(root.left);
            int rightDiam = diameter(root.right);
            int rh = maxHeight(root.right);

            int selfDiam = lh + rh + 1;

            int diamAns = Math.max(Math.max(rightDiam, leftDiam), selfDiam);

            return diamAns;
        }
    }
    

    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.binaryTreeBuiler(nodes);
        System.out.println("diam of tree is " + root.data);
        System.out.println(tree.diameter(root));
    } 
}
