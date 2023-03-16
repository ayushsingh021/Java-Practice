import java.util.*;
public class stockProfit{
    public static void maxProfit( int prices[]){
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0 ; i< prices.length ; i++){
            if(buyPrice<prices[i]){  
            //profit is possible as buy price is less than todays price 
                int profit = prices[i]-buyPrice;//todays profit
                maxProfit = Math.max(maxProfit, profit);
            }
            else{
            //matlab ajka price kam hai buyprice se to aj kahrido na
            buyPrice = prices[i];
            }
        }
     System.out.println("The Max profit is " + maxProfit);
    }
     public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
     int prices[] = {7,1,5,3,6,4};
     maxProfit(prices);
     System.out.println();
     sc.close();
    }
}