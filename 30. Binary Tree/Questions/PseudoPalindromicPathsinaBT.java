1457. Pseudo-Palindromic Paths in a Binary Tree
Solved
Medium
Topics
Companies
Hint
Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be pseudo-palindromic if at least one permutation of the node values in the path is a palindrome.

Return the number of pseudo-palindromic paths going from the root node to leaf nodes.

 

Example 1:



Input: root = [2,3,1,3,1,null,1]
Output: 2 
Explanation: The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the red path [2,3,3], the green path [2,1,1], and the path [2,3,1]. Among these paths only red path and green path are pseudo-palindromic paths since the red path [2,3,3] can be rearranged in [3,2,3] (palindrome) and the green path [2,1,1] can be rearranged in [1,2,1] (palindrome).
Example 2:



Input: root = [2,1,1,1,3,null,null,null,null,null,1]
Output: 1 
Explanation: The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the green path [2,1,1], the path [2,1,3,1], and the path [2,1]. Among these paths only the green path is pseudo-palindromic since [2,1,1] can be rearranged in [1,2,1] (palindrome).
Example 3:

Input: root = [9]
Output: 1

//method 1 : Normal array storing apprach

class Solution {

    public static int solve(TreeNode root , int[] list , int ans[]){
       if(root == null){
           return 0;
       }
       list[root.val]++;
       int left = solve(root.left , list,ans);
       int right = solve(root.right , list,ans);
       if(left == 0 && right == 0){
           int oddfreq = 0;
          for(int i = 0 ; i < 10 ; i++){
              if(list[i]%2 != 0){
                  oddfreq++;
              }
            }
         
          if(oddfreq == 0 || oddfreq == 1){
              ans[0]++;
          }
       }
       list[root.val]--;
       return 10;
   }
   public int pseudoPalindromicPaths (TreeNode root) {
           int list[] = new int[10];
           int ans[] = new int[1];
           solve(root , list,ans);
       return ans[0];
       
   }
}
