import java.util.*;
public class subarrays{
    public static void Subarray(int arr[]){
        int ts=0;
        // int sum=0;
        for(int i=0 ; i< arr.length ; i++){
            int start=i;
            for(int j= i ; j<arr.length ; j++){
                int end = j;
                for(int k= start ; k<=end ; k++){//print
                    System.out.print(arr[k] + " ");//subarray
                    //  sum = sum + arr[k];
            
                    //  System.out.print(sum);
                }
                ts++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("The no. of subarrays are :"+ ts);
         
    }
     public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int arr[]= {2,4,6,8,10};
    Subarray(arr);
     System.out.println();
     sc.close();
    }
}
