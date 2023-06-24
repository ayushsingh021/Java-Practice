import java.util.ArrayList;

public class Merge2Bsts {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static void getInorder(TreeNode root , ArrayList<Integer> arr){
        if(root == null){
            return;
        }

        getInorder(root.left,arr);
        arr.add(root.val);
        getInorder(root.right, arr);
    }
    public static TreeNode mergedBST(TreeNode root1 , TreeNode root2){
        //get inorder 
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        getInorder(root1 , arr1);
        getInorder(root2 ,arr2);
        //merge inorder
        ArrayList<Integer> finalArr = new ArrayList<>();
        int i = 0 , j = 0 ; 
        while(i< arr1.size() && j< arr2.size()){
            if(arr1.get(i)<= arr2.get(j)){
                finalArr.add(arr1.get(i));
                i++;
            }else{
                finalArr.add(arr2.get(j));
                j++;
            }
        }
        //leftOver
        while(i<arr1.size()){
            finalArr.add(arr1.get(i));
            i++;
        }
        while(j<arr2.size()){
            finalArr.add(arr2.get(j));
            j++;
        }
        //create merged BST from sorted merged inorder
        return createBST(finalArr , 0 , finalArr.size()-1);
    }
    public static TreeNode createBST(ArrayList<Integer> arr , int si ,int ei){
        int mid = (si+ei)/2;

        while(si>ei){
            return null; 
        }
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = createBST(arr, si, mid-1);
        root.right = createBST(arr, mid+1, ei);

        return root;
    }
    public static void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print( root.val +  " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    public static void main(String[] args) {

    //     2
    //    / \
    //   1   4
    //BST 1
    TreeNode root1 = new TreeNode(2);
    root1.left = new TreeNode(1);
    root1.right = new TreeNode(4);

    //       9
    //     /   \
    //    3     12
    //BST 2
    TreeNode root2 = new TreeNode(9);
    root2.left = new TreeNode(3);
    root2.right = new TreeNode(12);

    TreeNode rootAns = mergedBST(root1, root2);
    preOrder(rootAns);       
    }
    
}
