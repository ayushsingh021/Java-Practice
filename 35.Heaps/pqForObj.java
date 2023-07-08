import java.util.PriorityQueue;

public class pqForObj {
    static class Student implements Comparable<Student>{ //overridding
        String name;
        int rank;

        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }
        @Override
        public int compareTo(Student s2){
            return s2.rank - this.rank; // Dececnding
            // return this.rank - s2.rank; //ascending
        }

    }
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        
        pq.add(new Student("A", 4));
        pq.add(new Student("B", 5));
        pq.add(new Student("C", 1));
        pq.add(new Student("D", 9));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name + " --> " + pq.peek().rank);
            pq.remove();
        }
    }
    
}
