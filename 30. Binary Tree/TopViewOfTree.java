import java.util.*;
public class TopViewOfTree {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data =data;
            this.left = null;
            this.right = null;
        }
    }
    static class BinaryTree{
        static int idx = -1;
        public static Node binaryTreeBuilder(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = binaryTreeBuilder(nodes);
            newNode.right = binaryTreeBuilder(nodes);

            return newNode;
        }

        static class Info{
            Node node;
            int hd;

            public Info(Node node,int hd){
                this.node = node;
                this.hd =hd;
            }
        }

        public List<Integer> rightSideView(Node root) {
            List<Integer> ans = new ArrayList<>();
    
            Queue<Node> q = new LinkedList<>();
    
            q.add(root);
            q.add(null);
    
            while(!q.isEmpty()){
                Node curr = q.remove();
                if(curr == null){
                     if(q.isEmpty()){
                     break;
                    }
                    else{
                    q.add(null);
                    }
    
                }else{
                    ans.add(curr.data);
                    if(curr.right != null){
                        q.add(curr.right);
                    }
                }
            }
            return ans;
        }
        public static void topView(Node root){
            //level order traversal

            Queue<Info> q = new LinkedList<>();
            HashMap<Integer,Node> map = new HashMap<>();  //here we store the Key (Integer) --hd
            int max = 0 , min =0 ;
            q.add(new Info(root, 0));
            q.add(null);

            while(!q.isEmpty()){
                Info curr = q.remove();

                if(curr == null){
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }else{
                    if(!map.containsKey(curr.hd)){  //first time occuring key
                        map.put(curr.hd, curr.node);
                    }
                    if(curr.node.left != null){
                        q.add(new Info(curr.node.left, curr.hd -1));
                        min = Math.min(curr.hd-1, min);
                    }
    
                    if(curr.node.right != null){
                        q.add(new Info(curr.node.right, curr.hd +1));
                        max = Math.max(curr.hd+1, max);
                    }
    
                }

              
                
            }
            for(int i = min ; i<=max ; i++){
                System.out.print(map.get(i).data + " ");
            }
            System.out.println();

        }
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.binaryTreeBuilder(nodes);
        System.out.println("Topview");
        tree.topView(root);
        
        //right side view
        List<Integer> newArr = tree.rightSideView(root);
        System.out.println("RightSide view");
        while(!newArr.isEmpty()){
            System.out.print(newArr.remove(0) + " ");
        }
    }
}
