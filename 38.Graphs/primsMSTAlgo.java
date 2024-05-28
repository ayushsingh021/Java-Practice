import java.util.*;
public class primsMSTAlgo {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d , int w){
            this.src = s ; 
            this.dest = d; 
            this.wt = w;
        }
    }
    static void createGraph (ArrayList<Edge> graph[]){
        for(int i = 0 ; i < graph.length ; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 30));
    }

    static class Value implements Comparable<Value>{
        int sr; //src node
        int pathWt; //wt
        int parent; //parent of src node

        public Value(int src, int pathWt , int parent){
            this.sr = src ;
            this.pathWt = pathWt;
            this.parent = parent;
        }
        
        public int compareTo(Value p2){
            return this.pathWt - p2.pathWt; //ascending
        }
        
    }
    public static void primsMST(ArrayList <Edge> graph[]){
       
        // boolean vis[] = new  boolean[graph.length];
        boolean isMST[] = new boolean[graph.length] ;// is the node is taken in MST or not
        int V = graph.length;
        PriorityQueue<Value> pq = new PriorityQueue<>();
        pq.add(new Value(0, 0, -1));
        // pq.add(new Value(0, 0 , -1));
        int parArr[] = new int[V];
        Arrays.fill(parArr, -1);
        int finalCost = 0 ; // mst cost or total min wight ,, we can also create an AL for storing edges

        while(!pq.isEmpty()){
            Value curr = pq.remove();
            int node = curr.sr;
            int wt = curr.pathWt;
            int par = curr.parent;
        
            if(!isMST[node]){
                isMST[node] = true;
                finalCost += wt;
                parArr[node] = par;

                //neigh
                for(int i = 0 ; i < graph[node].size() ; i++){
                    Edge e = graph[node].get(i);
                    pq.add(new Value(e.dest, e.wt , node));
                }
            }
        }

        for(int i = 0 ; i < V; i++){
            System.out.println(parArr[i]+ " ");
        }

        System.out.println("Final min cost of MST is :" + finalCost);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList <Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        primsMST(graph);
    }
}
