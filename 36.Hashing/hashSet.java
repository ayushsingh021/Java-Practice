import java.util.HashSet;

public class hashSet {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(4);
        set.add(2);
        set.add(1);
        
        System.out.println(set);
        if(set.contains(2)){
            System.out.println("contains 2");
        }
        set.remove(4);
        if(!set.contains(4)){
            System.out.println("not contains 4");
        }
    }
    
}
