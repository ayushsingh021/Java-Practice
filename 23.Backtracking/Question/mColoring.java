// Given an undirected graph and an integer M. The task is to determine if the graph can be colored with at most M colors such that no two adjacent vertices of the graph are colored with the same color. Here coloring of a graph means the assignment of colors to all vertices. Print 1 if it is possible to colour vertices and 0 otherwise.

// Example 1:

// Input:
// N = 4
// M = 3
// E = 5
// Edges[] = {(0,1),(1,2),(2,3),(3,0),(0,2)}
// Output: 1
// Explanation: It is possible to colour the
// given graph using 3 colours.



//striver sheet
class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    



    //safety cheak of color so that no adjacent node have same color
    public static boolean isSafe(int node ,ArrayList<ArrayList<Integer>> adj , int[] color,int col ){
        for( int i = 0 ; i < adj.get(node).size() ; i++ ){
            if(color[adj.get(node).get(i)] == col ){
                return false;
            }
        }
        return true;
    }


    //main recursive function
    public static boolean graphColoringSol(int node, ArrayList<ArrayList<Integer>> adj , int m , int n , int[]color){
        //basee case
        if(node == n){
            //we reched till last call
            return true;
        }
        
        for(int i = 1 ; i<= m ; i++){
            if(isSafe(node ,adj , color , i )){
                color[node] = i; //put the color
                if(graphColoringSol(node +1 , adj , m,n,color)){
                    return true; //succeful
                }
                //backtracing the color to 0 if path fails
                color[node] = 0;
            }
        }
        return false;
    }
    public boolean graphColoring(boolean graph[][], int m, int n) {
        
        //adj matrix --> adj list convert
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < graph.length ; i++){
            for(int j = 0 ; j < graph[0].length ; j++){
                if(graph[i][j] == true){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        
        int color[] = new int[n] ;
        
        if(graphColoringSol(0,adj , m , n , color)){
            return true;
        }
        return false;
    }
}