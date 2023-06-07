import java.util.*;
public class ChocolaProblem {
    
    public static void main(String[] args) {
        //n x  m  dairymilk chocolate
        Integer costVer[] = { 2,1,3,1,4}; //m-1
        Integer costHor[] = {4,1,2 }; //n-1

        //sort decending
        Arrays.sort(costVer , Collections.reverseOrder());
        Arrays.sort(costHor , Collections.reverseOrder());

        //pointer to traverse
        int h = 0 , v = 0 ;
        int hp = 1 , vp =1;
        int cost = 0 ;

        while(h<costHor.length && v<costVer.length){
            if(costVer[v] <= costHor[h]){ //horizontal cut lagani hai
                cost = cost + (costHor[h] * vp);
                hp++;
                h++;
            }else{ //vertical cut lagani hai
                cost += (costVer[v] * hp);
                vp++;
                v++;

            }
        }
        //leftovers in hori
        while(h<costHor.length){
            cost = cost + (costHor[h] * vp);
            hp++;
            h++;
        }
        //leftovers in vertical
        while(v<costVer.length){
            cost += (costVer[v] * hp);
            vp++;
            v++;
        }

        System.out.println("The min. cost of cutting chocolate is : " + cost);
    }
}
