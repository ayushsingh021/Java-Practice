import java.util.*;
public class linkedhashMapOperation {
    public static void main(String[] args) {
        LinkedHashMap<String ,Integer> lhm = new LinkedHashMap<>();
        lhm.put("India" , 100);
        lhm.put("China" , 150);
        lhm.put("US" , 50);

        //for linked hashmap jis order me key and value pass kia tha we get at same
        System.out.println(lhm);
    }
}
