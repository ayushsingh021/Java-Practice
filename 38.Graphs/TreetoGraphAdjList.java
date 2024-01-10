/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// 2385. Amount of Time for Binary Tree to Be Infected
class Solution {
    // Tree to graph convertion
    public static void createGraph( HashMap<Integer , List<Integer>> adj , TreeNode curr , int parent){
        if(curr == null){
            return;
        }
        if(parent != -1){
            adj.computeIfAbsent(curr.val , k -> new ArrayList<>()).add(parent);
        }
        if(curr.left != null){
            adj.computeIfAbsent(curr.val , k -> new ArrayList<>()).add(curr.left.val);
        }
        if(curr.right != null){
            adj.computeIfAbsent(curr.val , k -> new ArrayList<>()).add(curr.right.val);
        }
        createGraph(adj , curr.left , curr.val);
        createGraph(adj , curr.right , curr.val);

    }
    public int amountOfTime(TreeNode root, int start) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        createGraph(adj , root , -1);

        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> vis = new HashSet<>();
        q.add(start);
        vis.add(start);
        int minute = 0;
        while(!q.isEmpty()){
            int n = q.size();
            while(n-->0){
                int curr = q.remove();
              //iterating in adjlist
                for(int neigh : adj.getOrDefault(curr, Collections.emptyList())){
                     if(!vis.contains(neigh)){
                        vis.add(neigh);
                        q.add(neigh);
                       }
                }
            }
            minute++;
        }

        return minute-1;

    }
}