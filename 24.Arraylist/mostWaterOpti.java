import java.util.*;
public class mostWaterOpti {

    public static int waterMax(ArrayList<Integer> ht , int lp , int rp  ){
        int maxWater = 0 ;

        while(lp<rp){
            int width = rp -lp;
            int height = Math.min(ht.get(rp), ht.get(lp));
            int currWater = width * height;
            maxWater = Math.max(maxWater, currWater);
            if(ht.get(lp)<ht.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }
        return maxWater;
    } 
    public static void main(String[] args) {
        ArrayList <Integer> ht = new ArrayList<>();
        ht.add(1); ht.add(8);ht.add(6);ht.add(2);ht.add(5);ht.add(4);
        ht.add(8);ht.add(3);ht.add(7);
        
        System.out.println(waterMax(ht,0,ht.size()-1));
    }    
}
