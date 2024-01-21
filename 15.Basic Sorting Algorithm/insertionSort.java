import java.util.*;

public class insertionSort {

    public static void insertSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;
            // finding out correct position to insert
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                printArr(arr);
                System.out.println();
                prev--;
            }
            // insertion
            arr[prev + 1] = curr;
            printArr(arr);
            System.out.println();
        }

    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = { 5, 6, 1, 3, 2 };
        printArr(arr);// before
        System.out.println();
        insertSort(arr);
        printArr(arr);// after
        System.out.println();
        sc.close();
    }
}