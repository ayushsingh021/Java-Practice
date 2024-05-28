import java.util.*;
public class dijkstraAlgo {
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
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    static class Pair implements Comparable<Pair>{
        //u,v logic
        int n; // node
        int path; //path

        public Pair(int n, int path){
            this.n = n;
            this.path = path;
        }

        @Override
        public  int compareTo(Pair p2){
            return this.path - p2.path; //path based sorting will return the min path
        }


    }
    public static void dijkstra(ArrayList<Edge> graph[] , int src){
            int dist [] = new int [graph.length]; //dist[i] --> dist from src to i
            for(int i= 0 ; i <  graph.length ;i++){
                if(i != src){
                    dist[i] = Integer.MAX_VALUE; //+infintiy
                }
            }
            boolean vis[]= new boolean[graph.length];
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            pq.add(new Pair(src, 0));
            //loop
            while(!pq.isEmpty()){
                Pair curr = pq.remove(); // automaticlly the min path node will come out for pq
                int pathDist = curr.path;//curr
                if(!vis[curr.n]){
                    vis[curr.n] = true;

                    //neighbours
                    for(int j = 0 ; j < graph[curr.n].size() ; j++){
                        Edge e = graph[curr.n].get(j);
                        //neigh
                        int v = e.dest;
                        int wt = e.wt;
                        //Dijkstra Logic
                        // curr + neighWt < neighDist  its win win then updata
                        if(pathDist+ wt < dist[v]){ //updated dist of src to v
                            dist[v] = pathDist + wt;
                            pq.add(new Pair(v, dist[v]));
                        }

                    }
                }
            }

            //print all src to vertices shotest dist
            for(int i = 0 ; i < dist.length; i++){
                System.out.print(dist[i] + " ");
            }
            System.out.println();

    }
    public static void main(String[] args) {
        int V = 6 ; 
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        int src = 0;//we can have any src
        dijkstra(graph, src);
    }

}
