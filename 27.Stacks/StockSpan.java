import java.util.*;

public class StockSpan {

    // public static int[] spanCalc(int arr[]){
    //     Stack<Integer> s = new Stack<>();
    //     int span[] = new int[arr.length];

    //     s.push(0);
    //     for(int i = 1 ; i < arr.length ; i++){
    //         if(arr[i] > arr[s.peek()]){
    //             s.push(i);
    //         }else{
    //             s.pop();
    //         }
    //         span[i] = i - s.peek();
    //     }
    //     return span;

    // } 
    public static void stockSpan(int stock[] , int span[]){
        //idx stack
        Stack<Integer> s = new Stack<>();
        s.push(0); //initialize stack
        span[0] =1; //initialize span

        for(int i = 1 ; i < stock.length ; i++ ){
            int curr = stock[i];
            while(!s.isEmpty() && curr > stock[s.peek()]){
                s.pop(); //agar span ke andar ke idx ka calue ka, hua to pop karna hai
            }
            if(s.isEmpty()){ //last elem case
                span[i] = i+1;
            }else{
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }

    }
    public static void main(String[] args) {
        int stock[]  = {100,80,60,70,60,85,100};
        // int ans[] = spanCalc(stock);
        int span[] = new int [stock.length];
        stockSpan(stock,span);
        for(int i = 0 ;i< span.length  ; i ++){
            System.out.print(span[i] + " ");
        }


    }
    
}
