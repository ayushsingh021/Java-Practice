import java.util.HashMap;

public class largestSubArr0sum {

    public static int sumZeroArr(int arr[]){
        int sum = 0 ;
        int len =0 ;
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int j = 0 ; j < arr.length ; j++){
            sum =sum + arr[j];
            if(hm.containsKey(sum)){
                len = Math.max(len , j - hm.get(sum));
            }else{
                hm.put(sum, j);
            }
        } 
        return len;
    }
    public static void main(String[] args) {
        int arr[] = {15, -2, 2,-8, 1, 7, 10};
        System.out.println("largest subarray with sum zero is of size :" + sumZeroArr(arr));
    }
    
}
