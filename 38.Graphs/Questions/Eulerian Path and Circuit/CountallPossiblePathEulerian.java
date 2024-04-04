// You are presented with an undirected connected graph consisting of n vertices and connections between them represented by an adjacency matrix. Your objective is to determine whether it is possible to start traversing from a node, x, and return to it after traversing all the vertices at least once, using each edge exactly once.

// Example 1:

// Input: 
// paths = 0 1 1 1 1
//         1 0 0 1 0
//         1 0 0 1 0
//         1 1 1 0 1
//         1 0 0 1 0
// Output: 1
// Explanation: 
// One can visit the vertices in the following way:
// 1->3->4->5->1->4->2->1 (assuming 1-based indexing)
// Here all the vertices has been visited and all
// paths are used exactly once.


class Solution
{
    public static void DFS (ArrayList<Integer> graph[] , int curr, boolean vis[]){
        // System.out.println(curr);
        vis[curr] = true;
        
        //cheak for all neigh of curr node
        for(int i = 0 ; i < graph[curr].size() ; i++){
            int neigh = graph[curr].get(i);
            if(vis[neigh] == false){
                //unvis
               DFS(graph , neigh , vis );
            }
        }
    }
    public static boolean isConnected(int V ,  ArrayList<Integer> graph[] ){
        int nonZeroDegVert = -1;
        for(int i = 0 ; i< V ; i++){
            if(graph[i].size() != 0){
               nonZeroDegVert = i ;
               break;
            }
        }
        
        boolean vis[] = new boolean[V];
        DFS(graph , nonZeroDegVert , vis); //start DFS from nonzero degree vert
        //cheak if all non zero deg wal vertices are vis
        
        for(int i = 0 ; i < V ; i++){
            if( vis[i] == false  && graph[i].size() != 0  ){
                // System.out.print(i + " *");
                return false;
            }
        }
        
        return true;
    }
    public int isPossible(int[][] paths)
    {   
        int n = paths.length;
        ArrayList<Integer> graph[] = new ArrayList[n]; //adj list
        for(int i = 0 ; i < n ; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(paths[i][j] == 1){
                    graph[i].add(j);
                }
            }
        }
        int V = n;//vertices
        
        //  for(int i = 0 ; i < n ; i++){
        //   for(int j =0 ; j < graph[i].size() ; j++){
        //       System.out.print(graph[i].get(j) + " ");
        //   }
        //   System.out.println();
        // }
        
        
        //cheak if all nonzero degree wale connected 
        if(isConnected(V , graph ) == false){
            // System.out.print("fail");
            return 0;
        }
        
        //count odd degree wale vertices
        int countoddDeg = 0;
        for(int i = 0 ; i < V ; i++){
            if(graph[i].size()%2 != 0){
                //odd deg
                countoddDeg++;
            }
        }
        
        if(countoddDeg == 0){
            return 1;
        }
        
        
        
       
        return 0;
        
        // return 1;
        
        
    }
}