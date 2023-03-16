import java.util.*;

public class countSort{
    public static void Sorting(int arr[]){
        //getting max rangr;
        int largest = Integer.MIN_VALUE;
        for(int i=0 ; i<arr.length ; i++){
            largest = Math.max(largest, arr[i]);
        }
        //counting the frequency
        int count[]= new int[largest+1];
        for(int i=0 ; i<arr.length ; i++){
            count[arr[i]]++;
        }
        //sorting
        int j=0;
        for(int i = 0;i<count.length; i++){
        while(count[i]>0){
            arr[j]=i;
            i++;
            count[i]--;
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
    Sorting(arr);
    printArr(arr);//after
     sc.close();
    }
}