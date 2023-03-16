import java.util.*;
public class MaxSubarrsum2{
    public static void MaxSubarrSum(int arr[]){
        int currSum ;
        int maxSum = Integer.MIN_VALUE;
  
        //getting prefix array
        int prefix[]= new int[arr.length];
          prefix[0]=arr[0];
          for(int i =1 ; i<prefix.length ; i++){
            prefix[i]= prefix[i-1] + arr[i];
          }
        
          for(int i=0 ; i< arr.length ; i++){
            int start=i;
        
            for(int j= i ; j<arr.length ; j++){
                int end = j;
            
                currSum = start == 0 ? prefix[end] : prefix[end]- prefix[start-1];
                
                System.out.println(currSum);
                if(currSum>maxSum){
                    maxSum=currSum;
                }
            }            
            System.out.println("*****");           

        }
        System.out.println("The max subarray sum is :" + maxSum);

        
         
    }
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[]= {1,-2,6,-1,4};
        MaxSubarrSum(arr);
     System.out.println();
     sc.close();
    }
}