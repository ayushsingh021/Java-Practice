public class lastOccu {

    // it is also working 
    // public static  int foundKey(int arr[] , int i , int key){
    //     if(i==0){
    //         return -1;
    //     }
    //     if(arr[i]==key){
    //         return i;
    //     }else{
    //         return foundKey(arr, i-1, key);
    //     }
        
    // }
    public static int lastOccur(int arr[] , int key , int i){
        if(i==arr.length){
            return -1;
        }
        int foundKey = lastOccur(arr, key, i+1);
        if(foundKey == -1 && arr[i]==key){
            return i;
        }
        return foundKey;
    

    }
    public static void main(String[] args){
        int arr[] = {8,3,6,9,5,10,2,5,3,7,5};
        // System.out.println( foundKey(arr, arr.length-1, 5 ));
        System.out.println( lastOccur(arr, 5, 0 ));

       
    }
    
}
