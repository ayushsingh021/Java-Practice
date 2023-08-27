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

    public static void dfs (ArrayList<Edge> graph[] ,boolean vis[], int curr ){
        vis[curr]  = true;
        System.out.print(curr + " ");
        for(int i = 0 ; i < graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph , vis , e.dest);
            }
        }
    }
    public static void kosaraju(ArrayList<Edge> graph[] ,int V){
        //step 1 : topsort and creating the stack
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];
        for(int i = 0 ; i < V ; i++){
            if(!vis[i]){
                topsort(s, vis, graph, i);
            }
        }

        //step 2 : creating the transpose graph
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for(int i = 0 ;  i < transpose.length ; i++){
            vis[i] = false;
            transpose[i] = new ArrayList<>();
        }

        for(int i = 0 ; i <V ; i++){
            for(int j = 0 ; j < graph[i].size() ; j++ ){
                Edge e = graph[i].get(j); //  e.src --> e.dest
                transpose[e.dest].add(new Edge(e.dest, e.src)); // reversed the edge
            }
        }

        //step 3 : appling dfs over the transposed graph
        while(!s.isEmpty()){
            int curr = s.pop();
            if(!vis[curr]){
                System.out.print("Scc ->");
                dfs(transpose,vis,curr); //scc
                System.out.println();
            }

        }

    }
    public static void main(String[] args) {
        int V = 5; 

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        kosaraju(graph, V);
    }
}
