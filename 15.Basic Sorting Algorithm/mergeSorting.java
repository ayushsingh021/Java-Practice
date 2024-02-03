public class mergeSorting {

    public static void printArr(int arr[]){
        for(int n = 0 ; n < arr.length ; n++ ){
            System.out.print(arr[n] + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int arr[], int si, int ei){
        //base case
        if(si >= ei){
            return;
        }
        //kaam
        // int mid = si + (ei-si)/2;
        int mid = (si + ei)/2;

        mergeSort(arr, si, mid);//leftpart
        mergeSort(arr, mid+1, ei);//rightpart
        merge(arr, si,mid,ei); 
    }
    public static void merge(int arr[],int si,int mid, int ei){
        //left(0,3)=4  rignt(4,6)=3 total =7 (6-0+1)
        int temp[] = new int [ei - si + 1];  //same as the forula f-i+1
        int i = si; //iterator for left part
        int j = mid+1;//iterator for right part
        int k =  0; //iterator for temp array

        //left and right sorted part getting merged through iterator model
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        //left part ke leftovers jo add karna
        while(i <= mid){
            temp[k++]=arr[i++];
        }

        //right part ke leftovers jo add karna
        while(j <= ei){
            temp[k++]= arr[j++];
        }
        //copying temp array to original array
        for(k=0 , i = si ; k < temp.length ; k++, i++){
            arr[i]=temp[k];
        }

    }
    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8};
        System.out.println(arr.length);
        mergeSort(arr, 0, arr.length-1);
        printArr(arr);
    }
    
}
