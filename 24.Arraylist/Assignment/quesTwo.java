import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class quesTwo{

    // public static void lonlyNum(ArrayList<Integer> list){
    //     int flag = 0;
    //     for(int i = 0 ; i<list.size() ;  i++){
    //         for(int j =i+1 ; j<list.size() ; j++){
    //             if(list.get(j)==list.get(i)){
    //                 flag = 1;
    //                 break;
    //             }
    //             else if(list.get(j)==list.get(i)+1){
    //                 flag = 1;
    //                 break;

    //             }
    //             else if(list.get(j)==list.get(i)-1){
    //                 flag = 1;
    //                 break;
    //             }
    //         }
    //         if(flag == 0){
    //         System.out.println(list.get(i));
    //         }
    //     }

    // }
    public static ArrayList<Integer> lonlyNum(ArrayList<Integer> list){
        //sort karlo
        Collections.sort(list);
        //store the answers in a Arraylist
        ArrayList<Integer> num = new ArrayList<>();

        for(int i = 1; i< list.size()-1 ;i++){
            if(list.get(i-1)+1 <list.get(i) && list.get(i)+1 < list.get(i+1) ) {//worth tohave in ans
                num.add(list.get(i));
            }
        }
        //but in previous loop we missed two index to cheak for possible ans;
        if(list.size() ==1){
            num.add(list.get(0));
        }
        if(list.size() > 1){
        if(list.get(0)+1 < list.get(1)){
            num.add(list.get(0));
        }
        if(list.get(list.size()-2)+1 < list.get(list.size()-1)){
            num.add(list.get(list.size()-1));
        }
        }
        return num;

    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(8);
        
        System.out.println(lonlyNum(list));
        // list.add(8);
        














        

    }
}