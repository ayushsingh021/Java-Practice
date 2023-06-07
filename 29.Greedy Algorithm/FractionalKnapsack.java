import java.util.*;
public class FractionalKnapsack{

    
    public static void main(String[] args) {
        int val[] = {60,100,120};
        int weight[] = {10,20,30};
        int W = 50; //capapcity of knapsack

        double ratio[][] = new double[val.length][2];
        //we need to col 2d array so that in col 0th we store idx and in col 1st we store ratio and retireve the old idx after sorting 
        for(int  i = 0 ; i<val.length ; i++){
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double)weight[i];
        } 

        //sort using lambda function 
        Arrays.sort(ratio , Comparator.comparing( o -> o[1]));  //chotot theke boro ascending order
        int capacity = W;
        int maxVal = 0 ;
        for(int i = ratio.length -1; i>=0 ; i--){
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]){ //include full items
                maxVal = maxVal + val[idx];
                capacity = capacity - weight[idx];
            }else{ // included fractional item
                maxVal = maxVal + (int)(ratio[i][1]*capacity);
                capacity=0;
            }
        }
        System.out.println("Max value can be gained : " + maxVal + " rs/-");
    }
}