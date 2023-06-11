import java.util.*;

public class BinaryTreePreOrderSeq {
 
    static class Node{
        int data;
        Node left;
        Node right;
        //constructor
        Node(int data){
            this.data =data;
            this.left = null;
            this.right = null;
        }
    }
    //binary tree preorder sequence
    static class BinaryTree{
        static int idx = -1;
        public static Node binaryTreeBuilder(int nodes[]){
            idx++;
            //base case
            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = binaryTreeBuilder(nodes);
            newNode.right = binaryTreeBuilder(nodes);

            return newNode;
        }   

         //Tree Traversal
    //Preoreder traversal
    public static void preOrder(Node root){
        if(root  == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //Inorder Traversal
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);

    }

    //PostOrder Traversal
    public static void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");


    }

    //LevelOrder Travearsal
    public static void levelOrder(Node root){
        if(root == null){
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{ //non -null currNode
                System.out.print( currNode.data + " ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }


    }

    }
   
    
   public static void main(String[] args) {
    int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
    BinaryTree tree = new BinaryTree();  //object creation
    Node root = tree.binaryTreeBuilder(nodes) ; //method call kia Binary tree ka
    // System.out.println(root.data);

    System.out.println("PreOrder");
    tree.preOrder(root);
    System.out.println();
    System.out.println( "Iorder");
    tree.inOrder(root);
    System.out.println();
    System.out.println("PostOrder");
    tree.postOrder(root);
    System.out.println();
    System.out.println("LevelOrder");
    tree.levelOrder(root);
    
   }
}
