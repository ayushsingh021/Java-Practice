import java.util.*;
public class kosarajuAlgoConncectedCompo {
    static class Edge{
        int src;
        int dest;
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]){ //cycle
        for(int i = 0 ;  i < graph.length ; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        
        graph[1].add(new Edge(1, 0));
        
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }


    public static void topsort( Stack<Integer> s,boolean vis[],ArrayList<Edge> graph[] ,int curr){
            vis[curr] = true;
            for(int i = 0 ; i < graph[curr].size() ; i++){
                Edge e = graph[curr].get(i);
                if(!vis[e.dest]){
                    topsort(s, vis, graph, e.dest);
                }
            }
            s.push(curr);
    }
    public static void kosaraju(ArrayList<Edge> graph[] ,int V){
        //topsort
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];
        for(int i = 0 ; i < V ; i++){
            if(!vis[i]){
                topsort(s, vis, graph, i);
            }
        }

        //step 2
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for(int i = 0 ;  i < transpose.length ; i++){
            transpose[i] = new ArrayList<>();
        }

    }
    public static void main(String[] args) {
        int V = 5; 

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
    }
}
