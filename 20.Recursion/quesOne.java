public class quesOne {

    /**
     * @param arr
     * @param index
     * @param key
     */
    public static void keyIndexAll(int arr[], int index, int key){
        //base case
        if(index == arr.length){
            return;
        }
        //kaam
        if(arr[index]==key){
            System.out.print(index+" ");
        }
        keyIndexAll(arr, index+1, key);

    }
    public static void main(String[] args) {
        int arr[] = {3,2,4,5,6,2,7,2,2};
        // int key = 2;
        keyIndexAll(arr, 0, 2);

    }   
}
