public class segmentTreesSum {

    //design segment trees
    static class SegmentTree{

        //node
        public class Node{
            int data;
            int startInterval;
            int endInterval;
            Node left;
            Node right;
            //constructor of node
            public Node(int startInterval , int endInterval){
                this.startInterval = startInterval;
                this.endInterval = endInterval ;
            }
        }

        Node root;

        //constrcutor segment trees
        public SegmentTree(int arr[]){
            //create a tree using this array
            this.root = constructTree(arr , 0 , arr.length-1);
        }

        private Node constructTree(int arr[] , int start , int end){
            if(start == end){
                //base case
                Node leaf = new Node(start, end);
                leaf.data = arr[start];
                return leaf;
            }

            int mid = start + (end-start)/2;

            Node node = new Node(start , end);
            node.left = this.constructTree(arr, start, mid);
            node.right = this.constructTree(arr, mid+1, end);

            node.data = node.left.data + node.right.data;

            return node;

        }

        //functions of segment trees
        public void display() {
            display(this.root);
        }
        private void display(Node node) {
            String str = "";
        
            if(node.left != null) {
              str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: " + node.left.data + " => "; 
            } else {
              str = str + "No left child";
            }
        
            // for current node
            str = str + "Interval=[" + node.startInterval + "-" + node.endInterval + "] and data: " + node.data + " <= "; 
            
            if(node.right != null) {
              str = str + "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: " + node.right.data; 
            } else {
              str = str + "No right child";
            }
        
            System.out.println(str + '\n');
        
            // call recursion
            if(node.left != null) {
              display(node.left);
            }
        
            if(node.right != null) {
              display(node.right);
            }
        }
        
        //query
        public int querySum(int qsi , int qei){
            return this.query(this.root , qsi , qei);
        }

        private int query(Node node , int qsi , int qei){

            if(node.startInterval >= qsi && node.endInterval <= qei) {
                // node is completely lying inside query
                return node.data;
              } 
              else if (node.startInterval > qei || node.endInterval < qsi) {
                // completely outside
                return 0;
              }
              else {
                return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
              }
        }
    }
    public static void main(String[] args) {
        int arr[] = {3,8,7,6,-2,-8,4,9};
        SegmentTree sg  = new SegmentTree(arr);

        sg.display();
    }
    
}