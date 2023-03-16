import java.util.ArrayList;

public class pairSumBrute {

    public static void pairKey(ArrayList<Integer> num , int key){
        for(int i =0 ; i< num.size() ; i++){
            for(int j = i+1; j<num.size() ; j++ ){
                if(num.get(i) + num.get(j) == key){
                    System.out.print("("+ num.get(i) +" ,"+ num.get(j) +")");
                }
            }
            System.out.println();
        }
        

    }
    public static void main(String[] args) {
        ArrayList<Integer> num = new ArrayList<>();
        num.add(1);
        num.add(2);
        num.add(6);
        num.add(4);
        num.add(5);
        num.add(3);
        pairKey(num ,5);
    }
    
}
