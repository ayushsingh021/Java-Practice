import java.util.Scanner;

public class hashh{
    public static void printArr(int arr[] ,int n){
        for(int i= 0 ; i< n ; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int arr[] = new int[100];
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n = sc.nextInt();

        for(int i = 0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }
        printArr(arr,n);

        //precompute
        int size = 13;
        int value = 0;
        int hashArr[] = new int[size];
        for(int k=0 ; k<= hashArr.length ; k++){
            hashArr[k] = value;
        }

        for(int j=0 ; j<n ; j++){
            hashArr[arr[j]] += 1;
        }
        printArr(hashArr, n);
         
    }
}