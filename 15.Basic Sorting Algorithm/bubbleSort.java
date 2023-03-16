import java.util.*;
public class bubbleSort{
    public static void bubSort(int arr[]){
        for(int turn=0 ; turn < arr.length-1 ; turn++){
            for(int j=0 ; j< arr.length-1-turn ;j++){
                if(arr[j]>arr[j+1]){
                    //swap
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    public static void printArr(int arr[]){
        for(int i=0 ; i<arr.length ;i++){
            System.out.print(arr[i]+ " ");
        }
    }
     public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int arr[]= {5,4,1,3,2};
    printArr(arr);//before
    System.out.println();
    bubSort(arr);
    printArr(arr);//after
     System.out.println();
     sc.close();
    }
}