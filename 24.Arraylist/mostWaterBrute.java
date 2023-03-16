import java.util.ArrayList;

public class mostWaterBrute {

    public static int waterCalc(ArrayList<Integer> ht){
        int height ; int width; 
        int maxWater = 0 ;
        //bruteForce -  TC = O(n^2);

        for(int i= 0 ; i< ht.size() ; i++){
            for(int j = i+1 ; j<ht.size() ; j++ ){
                height = Math.min(ht.get(i), ht.get(j));
                width = j -i ;               
               int currWater = height * width;
               maxWater = Math.max(maxWater, currWater);
             
               
            }
        }
        return maxWater;
        
    }


    public static void main(String[] args) {
        ArrayList <Integer> ht = new ArrayList<>();
        ht.add(1); ht.add(8);ht.add(6);ht.add(2);ht.add(5);ht.add(4);
        ht.add(8);ht.add(3);ht.add(7);
        System.out.println(waterCalc(ht));


        
    }
    
}
