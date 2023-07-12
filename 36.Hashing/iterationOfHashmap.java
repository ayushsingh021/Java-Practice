import java.util.*;

public class iterationOfHashmap {
    
    public static void main(String[] args) {
        HashMap<String ,Integer> hm = new HashMap<>();

        hm.put("India" , 100);
        hm.put("China", 150);
        hm.put("Nepal", 20);
        hm.put("US", 50);

        //iterate
        Set<String> key = hm.keySet();
        //foreach   
        for (String k : key) {
            System.out.println( "key = " + k + ", value = " + hm.get(k));
        }
        System.out.println(hm.entrySet());
    }
}
