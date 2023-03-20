import java.util.ArrayList;
//Monotonic ArrayList
public class quesOne {
    public static boolean monotonic(ArrayList<Integer> list){
        int i = 0 ;
        int j = i+2;
    
        if(list.get(i)<=list.get(j)){
            for(int mid= (i+j)/2 ; mid < list.size()-1 ; mid++){
                if(list.get(mid)<list.get(mid-1) || list.get(mid)>list.get(mid+1)){
                    return false;
                }else{
                    return true;
                }
            }
        }else{
            for(int mid= (i+j)/2 ; mid < list.size()-1 ; mid++){
                if(list.get(mid)>list.get(mid-1) || list.get(mid)<list.get(mid+1)){
                    return false;
                }else{
                    return true;
                }
            }

        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList <Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        // list.add(8);
        if(monotonic(list)){
        System.out.println("The list is monotonic");
        }

    }
    
}
