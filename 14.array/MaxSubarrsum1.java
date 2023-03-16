import java.util.*;
public class MaxSubarrsum1{
    public static void MaxSubarrSum(int arr[]){
        int currSum ;
        int maxSum = Integer.MIN_VALUE;
        // int sum=0;
        for(int i=0 ; i< arr.length ; i++){
            int start=i;
            for(int j= i ; j<arr.length ; j++){
                int end = j;
                currSum=0;
                for(int k= start ; k<=end ; k++){//print                          //sum subarray
                      currSum = currSum + arr[k];
            
                    //  System.out.print(sum);
                }
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
        int arr[]= {1,-2,6,-1,3};
        MaxSubarrSum(arr);
     System.out.println();
     sc.close();
    }
}