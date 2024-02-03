public class quickSorting {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    public static void quickSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int pidx = pivotWork(arr, si, ei);

        quickSort(arr, si, pidx - 1);
        quickSort(arr, pidx + 1, ei);

    }

    public static int pivotWork(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si;

        // j--itr; i-- static ptr moves only when swap
        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                // swap i & j
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        // swap pivot and ith

        int temp = pivot;
        arr[ei] = arr[i]; // ei -- index of pivot
        arr[i] = temp;

        return i;
    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 8, 2, 5 };
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}
