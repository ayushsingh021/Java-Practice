import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class quesThree {

    public static int findAns(ArrayList<Integer> list , int key){
        ArrayList <Integer> num =new ArrayList<>();
        for(int i = 0; i<list.size() ; i++){
            if(list.get(i)==key){
                num.add(list.get(i+1));
            }
        }
        // System.out.print(num + " ");

        int ans = maxCount(num);

        return ans;

    }
    public static int maxCount(ArrayList<Integer> num){
        Collections.sort(num);
        // System.out.println(num);
        int count = 1;
        int no = num.get(0);
        int countMax = 0;
        // int idx = 0;
        // System.out.println(num.size());
        for(int i = 1 ; i<num.size() ; i++){
            // System.out.println(num.get(i)+"  "+num.get(i-1));
            int a =num.get(i);
            int b=num.get(i-1);
            // if(num.get(i-1) !=num.get(i)){ 
            //never run a External function in conditional statement makeits variable and then do
            if(a!=b){
                if(count > countMax){
                    no = num.get(i-1);
                    countMax= count;
                    count= 0;
                }else{
                    count = 0;
                }
                // System.out.println(count);
            }
            count++;
        }
        // System.out.println(count);
        // System.out.println(countMax);
        if(count > countMax){
            no = num.get(num.size()-1);
            countMax= count;
            count= 0 ;
        }
        return no;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(100);
        // list.add(1);
        // list.add(100);
        // list.add(1);
        // list.add(100);
        list.add(1);
        list.add(200);
        list.add(1);
        list.add(200);
        list.add(1);
        list.add(200);
        list.add(1);
        list.add(100);
        System.out.println(findAns(list, 1));

    }
}
