import java.util.*;
public class sortArr{
    public static boolean isSorted(int arr[] , int i ){
        if(i == arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);

        
    }
     public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int arr[] = {1,2,5,3,4};
    
    if(isSorted(arr, 0)==true){
        System.out.println("Array is sorted ");
    }else{
        System.out.println("Array is unsorted");
    }
     System.out.println();
     sc.close();
    }
}