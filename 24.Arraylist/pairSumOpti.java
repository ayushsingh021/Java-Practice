import java.util.ArrayList;

public class pairSumOpti {

    public static boolean keyPair(ArrayList<Integer> num , int key , int si ,int ei ){
        int sum = num.get(ei) + num.get(si);
        while(si<ei){
           //case1
            if(sum == key){ //got
                return true;
            }
            if(sum < key){ // need to dec 
                //so we need to dec the num that are added now we know it is a sorted arrlist
                //from si -- num inc and ei--- num dec
                si++;
            }else{
                ei--;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        ArrayList<Integer> num = new ArrayList<>();
        num.add(1);
        num.add(2);
        num.add(3);
        num.add(4);
        num.add(5);
        num.add(6);
        System.out.println(keyPair(num, 3, 0, num.size()-1));
        

    }
    
}
