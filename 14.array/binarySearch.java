import java.util.*;
public class binarySearch{

    public static int binarysearch(int arr[] , int key){
        int start =0 ; 
        int end =arr.length-1;
        while(start<=end){
            int mid = (start + end)/2;
            if(arr[mid]==key){//found
                return mid;
            }
            if(arr[mid]>key){//left
                end = mid-1;
            }
            else{//right
                start = mid+1;
            }
        }
        return -1;

    }
     public static void main(String[] args) {
     int arr[]={2,3,4,5,6,8,10,11,12}; //sorted manually in inc order
     int key = 4;

     System.out.println("the index of the key " + binarysearch(arr, key));
     
    }
}