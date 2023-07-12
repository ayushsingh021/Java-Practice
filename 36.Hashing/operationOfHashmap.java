import java.util.*;
public class operationOfHashmap{
    public static void main(String[] args) {
        //create
        HashMap<String,Integer> hm = new HashMap<>();
        //insert
        hm.put("India" , 100);
        hm.put("China", 150);
        hm.put("Nepal", 20);
        hm.put("US", 50);

        //print
        System.out.println(hm);

        //Get -O(1)
        int population = hm.get("India");
        System.out.println(population);
        System.out.println(hm.get("indonesia")); //if not contain key then returns null

        //containskey
        System.out.println(hm.containsKey("China"));

        //remove
        hm.remove("China");
        System.out.println(hm);

        //size
        System.out.println(hm.size());

        //isEmpty
        System.out.println(hm.isEmpty());

        hm.clear(); // delates all maps in hashmap
        System.out.println(hm.isEmpty());
    }
}