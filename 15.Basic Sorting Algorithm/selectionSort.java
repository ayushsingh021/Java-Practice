import java.util.*;
public class selectionSort{
    public static void selectSort(int arr[]){
        for(int turn=0; turn<arr.length-1; turn++){
            int minPos = turn;
            for(int j=turn+1 ; j< arr.length;j++){
                if(arr[minPos]>arr[j]){
                    minPos=j;
                }
            }
            //swap
            int temp = arr[minPos];
            arr[minPos]=arr[turn];
            arr[turn]=temp;
        }
    }
    public static void printArr(int arr[]){
        for(int i=0 ; i<arr.length ;i++){
            System.out.print(arr[i]+ " ");
        }
    }
     public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int arr[]= {5,6,1,3,2};
    printArr(arr);//before
    System.out.println();
    selectSort(arr);
    printArr(arr);//after
     System.out.println();
     sc.close();
    }
}