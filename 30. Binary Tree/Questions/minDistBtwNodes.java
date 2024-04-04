// Given a binary tree with n nodes and two node values, a and b, your task is to find the minimum distance between them. The given two nodes are guaranteed to be in the binary tree and all node values are unique.

// Example 1:

// Input:
//         1
//       /  \
//      2    3
// a = 2, b = 3
// Output: 
// 2
// Explanation: 
// We need the distance between 2 and 3. Being at node 2, we need to take two steps ahead in order to reach node 3. The path followed will be: 2 -> 1 -> 3. Hence, the result is 2. 
// Example 2:

// Input:
//         11
//       /   \
//      22  33
//     /  \  /  \
//   44 55 66 77
// a = 77, b = 22
// Output: 
// 3
// Explanation: 
// We need the distance between 77 and 22. Being at node 77, we need to take three steps ahead in order to reach node 22. The path followed will be: 77 -> 33 -> 11 -> 22. Hence, the result is 3.


class GfG {
    
    
    public static Node lcaFind(Node root , int a, int b){
        if(root == null){
            return null;
        }
        if(root.data == a || root.data == b){
            return root;
        }
        Node left = lcaFind(root.left,a,b);
        Node right = lcaFind(root.right,a,b);
        
        if(left != null && right != null){
            //got lca
            return root;
        }
        
        return left != null ? left : right;
        
    }
    public static int distBtwNode(Node lca, int val){
        if(lca == null){
            return -1;
        }
        if(lca.data == val){
            return 0;
        }
        int left = distBtwNode(lca.left , val);
        int right= distBtwNode(lca.right , val);
        
        if(left == -1 && right == -1){
            return -1;
        }
        
        return left == -1 ? right+1 : left+1;
    }
    int findDist(Node root, int a, int b) {
        // Your code here
        Node lca = lcaFind(root,a,b);
        int dist1 = distBtwNode(lca , a);
        int dist2 = distBtwNode(lca , b);
        
        return dist1+dist2;
    }
}
