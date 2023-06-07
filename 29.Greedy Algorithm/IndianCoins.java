import java.util.ArrayList;

import javax.swing.plaf.synth.SynthStyle;

public class IndianCoins {
    
    public static void main(String[] args) {
        int coins[] = {1,2,5,10,20,50,100,500,2000};
        int val =590;
        ArrayList<Integer> ans = new ArrayList<>();
        int noOfCoins = 0 ;
        int remainingVal = val;
        for(int i = coins.length-1 ; i >= 0 ; i--){
            if(coins[i] <= remainingVal){
               while(coins[i]<= remainingVal){
                noOfCoins++;
                ans.add(coins[i]);
                remainingVal -= coins[i];
               }
                // System.out.println(remainingVal);
            }
        }
        System.out.println("The min coins require to get " + val + " is " + noOfCoins  );
        for(int j = 0 ; j < ans.size() ; j++){
            System.out.print( ans.get(j) + " ");
        }
    }
}
