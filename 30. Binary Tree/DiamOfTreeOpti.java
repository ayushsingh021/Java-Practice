public class DiamOfTreeOpti {

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
        //optimized way -- TC = O[n]
       static class Info{
        int diam;
        int ht;

        public Info(int diam ,int ht){
            this.diam = diam;
            this.ht = ht;
        }
       }

       public static Info diameterOpti(Node root){

        if(root == null){
            return new Info(0,0);
        }
        Info leftinfo = diameterOpti(root.left);
        Info rightinfo = diameterOpti(root.right);

        int diam = Math.max(Math.max(leftinfo.diam,rightinfo.diam) , leftinfo.ht + rightinfo.ht  + 1);
        int ht = Math.max(leftinfo.ht,rightinfo.ht) +1;

        return new Info(diam,ht);
       }
    }
    

    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.binaryTreeBuiler(nodes);
        System.out.println("diam of tree is " + root.data);
        System.out.println(tree.diameterOpti(root).diam);
    } 
    
}
