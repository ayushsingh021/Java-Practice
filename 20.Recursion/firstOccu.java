public class firstOccu {
    public static int foundKey(int arr[], int i){
        int key = 9;
        if(i == arr.length-1){
            return -1;
        }
        if(key==arr[i]){
            return i;
        }else{
            return foundKey(arr, i+1);
        }
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,9,7,6,0};
        // int key= 9;
        
        if(foundKey(arr, 0)==-1){
            System.out.println("Does not exist");
        }else{
            System.out.println("The key is at index " + foundKey(arr , 0 ));
        }  
    }
    
}
