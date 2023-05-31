import java.util.*;

public class nextGreaterElemArr {

    public static void nextGreaterElem(int arr[] , int nextGE[]){
        Stack<Integer> s = new Stack<>();
        for(int i = arr.length-1 ; i>=0 ; i--){
            //while
            //here stack is only accesed for idx's not for value
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }
            //ifelse
            if(s.isEmpty()){
                nextGE[i] = -1;
            }else{
                nextGE[i] = arr[s.peek()];
            }
            //s push
            s.push(i); //index ko push kar rhe istead of element
        }
    }
    public static void main(String[] args) {
        int arr[] = {6,8,0,1,3};
        int nextGE[] = new int[arr.length];
        nextGreaterElem(arr,nextGE);
        for(int j = 0 ;  j < nextGE.length ; j++){
            System.out.print(nextGE[j] + " ");
        }
    }
    
}
