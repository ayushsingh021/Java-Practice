import java.util.ArrayList;

public class pairSum2{

    public static boolean pairSumFind(ArrayList<Integer> num , int key){
        int n = num.size();
        int bp = -1; //any random idx is assigned 
         //find pivot/break point 
        for(int i = 0 ; i <num.size() ; i++){
            if(num.get(i) > num.get(i+1)){
                bp = i;
                break; //yehi se khatam akrdo loop
            }
        }

        int rp = bp ;   //greatest no is the right pointer
        int lp = bp +1 ;  // smallest no is the left pointer

        while(rp!=lp){
            if(num.get(rp) + num.get(lp) == key){ //case 1
                return true;
            }
            if(num.get(rp) + num.get(lp) > key){
                rp = (n+rp-1) % n ;
            }else{
                rp = (rp +1)%n;
            }
        }
        return false;

    }
    public static void main(String[] args) {
         ArrayList<Integer> num = new ArrayList<>();
         //sorted and rotated array
         num.add(11);
         num.add(15);
         num.add(6);
         num.add(8);
         num.add(9);
         num.add(10);
         int key = 14;
         System.out.println(pairSumFind(num, key));
         
    }
}