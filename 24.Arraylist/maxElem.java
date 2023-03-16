import java.util.ArrayList;

public class maxElem {

    public static  int getMax(ArrayList<Integer> list ){
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < list.size(); i++){
            if(list.get(i) > max){
                max= list.get(i);
            }
        }
        return  max;
        
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);

        System.out.println(getMax(list));
    }
    
}
