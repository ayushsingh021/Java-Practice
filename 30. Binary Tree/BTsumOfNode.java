public class BTsumOfNode {
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
         public static int sum(Node root){
            if(root == null){
                return 0;
            }

            int leftSum = sum(root.left);
            int rightSum = sum(root.right);
            int finalSum = leftSum + rightSum + root.data;

            return finalSum;
         }
        }
        
    
        public static void main(String[] args) {
            int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
            BinaryTree tree = new BinaryTree();
            Node root = tree.binaryTreeBuiler(nodes);
            System.out.println("root of tree is " + root.data);
            System.out.print("Sum of the nodes is : ");
            System.out.println(tree.sum(root));
        }
    
}
