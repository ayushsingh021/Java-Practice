public class matrixChainMultiplication{
    public static int mcmRec(int arr[] , int i , int j ){
        if(i == j ){
            //single matrix;
            return 0;
        }
        //Ai == arr[i-1]*arr[i]
        int ans = Integer.MAX_VALUE;
        for(int k = i ; k <= j-1 ; k++){
            int cost1 = mcmRec(arr, i, k); //set1 -- arr[i-1]xarr[k] -- < Ai.....Ak
            int cost2 = mcmRec(arr, k+1, j); //set1 -- arr[k]xarr[j] -- < Ak+1.....Aj
            int cost3 = arr[i-1]*arr[k]*arr[j];
            int totalCost = cost1 + cost2+ cost3;
            ans = Math.min(ans,totalCost) ;
        }

        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};//n=5
        int n = arr.length;

        System.out.println(mcmRec(arr, 1, n-1));
    }
}
