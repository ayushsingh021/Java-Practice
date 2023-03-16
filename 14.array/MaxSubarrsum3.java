import java.util.*;
public class MaxSubarrsum3{
  public static void kadane(int arr[]){
    int ms = Integer.MIN_VALUE; //maxsum
    int cs = 0 ;
    for(int i =0 ; i <arr.length ; i++){
        cs = cs + arr[i];
        if(cs<0){
            cs = 0;
        }
      ms = Math.max(ms, cs); //comparison
    }
   
    System.out.println("The max sum subarray is :" + ms);

  }
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[]= {-2,-3,4,-1,-2,1,5,-3};
        kadane(arr);
     System.out.println();
     sc.close();
    }
}

