public class SortedArrTOBST {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.val =data;
            this.left =null;
            this.right = null;
        }
    }
    public static void preOrder(TreeNode root){
        if(root == null){
            return; 
        }
        System.out.print( root.val + " ");
        preOrder(root.left);
       
        preOrder(root.right);
    }

    public static TreeNode balacedBSTcreate(int arr[] ,int si ,int ei){
        if(si>ei){
            return null;
        }
        int mid = (si + ei)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = balacedBSTcreate(arr, si, mid -1);
        root.right = balacedBSTcreate(arr, mid+1, ei);
        
        return root;
    }

    public static void main(String[] args) {
        int arr[] = { 3,5,6,8,10,11,12};
        TreeNode root = balacedBSTcreate(arr, 0, arr.length -1);
        preOrder(root);
    }
}
