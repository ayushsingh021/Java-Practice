import java.util.*;
public class topologicalSortBFS {
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
        graph[2].add(new Edge(2, 3));

        
        graph[3].add(new Edge(3, 1));
        
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
        
    }

    public static void calIndeg(ArrayList<Edge> graph[] , int indeg[]){
        for(int i = 0 ; i < graph.length ; i++){
            int vertex = i ;
            for(int j = 0 ; j < graph[vertex].size() ; j++){
                Edge e = graph[vertex].get(j);
                //neigh -->indeg inc
                indeg[e.dest]++;
            }
        }
    }
    public static void topSort(ArrayList<Edge> graph[]){
        int indeg[] = new int[graph.length];
        calIndeg(graph,indeg);

        Queue<Integer> q = new LinkedList<>();
        for(int  i = 0 ; i < indeg.length ;i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        //bfs work
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr + " ");  //toplogical sort ko print kar rhe
            for(int j = 0 ; j < graph[curr].size() ; j++ ){
                Edge e = graph[curr].get(j);
                //e.dest  -- > neighbour
                indeg[e.dest]--;
                if(indeg[e.dest] == 0 ){
                    q.add(e.dest);
                }
            }
        }
        System.out.println();

    }
    public static void main(String[] args) {
        int  V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        topSort(graph);
    }
}
