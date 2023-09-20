import java.util.*;
public class profitStock{

    public static int profitCalc(int prices[]){
        int Maxprofit =0 ;
        int buyPrice = Integer.MAX_VALUE;
    
        for(int i =0 ; i <prices.length; i++){
            if(buyPrice< prices[i]){//bechdo
                int profit = prices[i]-buyPrice;
                Maxprofit = Math.max(Maxprofit, profit); 
            }
            else{
                buyPrice= prices[i];
            }
        }
        return Maxprofit;     
    }
     public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int prices[] = {7,1,5,3,6,4};
    System.out.println("The profit is " + profitCalc(prices));
     System.out.println();
     sc.close();
    }
}