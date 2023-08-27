
import java.util.*;
public class tarzansAlgorithm {
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
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
    }

    public static void dfs( ArrayList<Edge>graph[],  boolean vis[] , int curr , int par, int[]dt , int[] low, int time){
            vis[curr] = true;
            dt[curr] = low[curr] = ++time;

            for(int i= 0 ; i < graph[curr].size() ; i++){
                Edge e = graph[curr].get(i);  //e.src ---> e.dest
                int neigh =e.dest;
                //3 posibilities
                if(neigh == par){
                    continue;
                }
                else if(!vis[neigh]){
                    dfs(graph, vis, neigh, curr, dt, low, time);
                    low[curr] = Math.min(low[curr], low[neigh]);
                    if(dt[curr] < low[neigh]){
                        //bridge condition
                        System.out.print( "Bridge : " + curr + "---" + neigh +" ");
                    }
                }else{ //vis[neigh]
                    low[curr] = Math.min(low[curr], dt[neigh]);
                }
            }
    }
    public static void tarzanBridge( ArrayList<Edge>graph[] ,int V){
            int dt[] = new int[V];
            int low[] = new int[V];
            int time = 0 ;
            boolean vis[] = new boolean[V];

            for(int i = 0 ; i < V ; i++){
                if(!vis[i]){
                    dfs(graph,vis,i, -1 ,dt,low, time );
                }
            }
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>graph[] = new ArrayList[V];
        createGraph(graph);
        tarzanBridge(graph, V);

    }
}
