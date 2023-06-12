public class KthLevelTree {
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
        public static void kLevel(Node root , int level ,int k){
            //basecase
            if(root == null){
                return;
            }
            if(level == k){
                System.out.print(root.data+ " ");
                return;
            }

            kLevel(root.left, level+1, k);
            kLevel(root.right, level+1, k);

        }
       
    }
    

    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.binaryTreeBuiler(nodes);
        int k = 3;
        tree.kLevel(root, 1, k);
    
    } 
}
