// Given a binary tree with n nodes, determine whether all the leaf nodes are at
// the same level or not. Return true if all leaf nodes are at the same level,
// and false otherwise.

// Example 1:

// Input:
// Tree:
// 1
// / \
// 2 3
// Output:
// true
// Explanation:
// The binary tree has a height of 2 and the leaves are at the same level.
// Example 2:

// Input:
// Tree:
// 10
// / \
// 20 30
// / \
// 10 15
// Output:
// false
// Explanation:
// The binary tree has a height of 3 and the leaves are not at the same level.

class Solution {
    public static int treeHeight(Node root) {
        if (root == null) {
            return 0;
        }

        int lh = 1 + treeHeight(root.left);
        int rh = 1 + treeHeight(root.right);

        return Math.max(lh, rh);

    }

    boolean check(Node root) {
        int ht = treeHeight(root);

        // level Order Traversal
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 1;

        while (!q.isEmpty()) {
            int n = q.size();

            Node curr = null;
            while (n-- > 0) {
                curr = q.remove();
                boolean l = false;
                boolean r = false;
                if (curr.left != null) {
                    q.add(curr.left);
                    l = true;
                }
                if (curr.right != null) {
                    q.add(curr.right);
                    r = true;
                }
                if (l == false && r == false) {
                    // left node
                    if (level != ht) {
                        return false;
                    }
                }
            }
            level++;
        }

        return true;
    }
}
