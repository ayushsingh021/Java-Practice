// import .java.util.*;

public class keyFind{
    public static void keyIdx( int arr[] , int key , int i){
        //base case
        if(i==arr.length){
            return;
        }
        //recursion
        if(arr[i]==key){
            System.out.print(i + " ");
        }
        keyIdx(arr, key, i+1);
    }
     public static void main(String[] args) {
    //  Scanner sc = new Scanner(System.in);
    //  System.out.println();
    //  sc.close();
    int arr[] = {3,2,4,5,6,2,7,2,2};
    int key = 2;
    keyIdx(arr, key, 0);
     }
}