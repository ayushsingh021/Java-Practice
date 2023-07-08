import java.util.*;
public class pqInJcf{
   
    public static void main(String[] args) {
        // PriorityQueue<Integer> pq = new  PriorityQueue<>(); //by default small no
        PriorityQueue<Integer> pq = new  PriorityQueue<>(Comparator.reverseOrder()); //by default greater no
        pq.add(3);
        pq.add(1);
        pq.add(7);
        pq.add(4);

        while(!pq.isEmpty()){
            System.out.println(pq.peek());
            pq.remove();
        }
        

    }
}