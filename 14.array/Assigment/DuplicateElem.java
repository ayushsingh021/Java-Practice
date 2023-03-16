import java.util.*;
public class DuplicateElem{
    // public static void printArray(int arr[], int size){
    //     for(int i =0 ; i<size ; i++){
    //         System.out.print( arr[i]+ "");
    //     }
    // }
    public static boolean duplicateElem(int arr[]){
    
        for(int i = 0; i <arr.length-1 ; i++){
            for(int j=i+1 ; j<arr.length; j++){
                if(arr[i]==arr[j]){
                    return true;
                }
                
            }
        }
    return false;

    }
     public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int arr[]= new int[5];
    System.out.println("Enter the element of array");
    // int size = sc.nextInt();
    for(int i=0 ; i<arr.length ;i++){
        arr[i]= sc.nextInt();
    }
    boolean a = duplicateElem(arr);
    System.out.println(a);

     System.out.println();
     sc.close();
    }
}