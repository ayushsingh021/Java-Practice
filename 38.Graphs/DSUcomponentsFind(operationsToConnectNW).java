// There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.

// You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.

// Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.

 

// Example 1:


// Input: n = 4, connections = [[0,1],[0,2],[1,2]]
// Output: 1
// Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
// Example 2:


// Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
// Output: 2
// Example 3:

// Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
// Output: -1
// Explanation: There are not enough cables.



class Solution {

        public int par[] ;
        public int rank[] ;
        
      
        public int find(int x) {
            if(par[x] == x){
                return x;
            }
            
            //path compression
            return par[x] = find(par[x]);
        }
        
        public void union(int a , int b){
            int parA = find(a);
            int parB = find(b);
            
            if(rank[parA] == rank[parB] ){
                par[parB] = parA;
                rank[parA]++;
            }
            else if(rank[parB] > rank[parA]){
                par[parA] = parB;
            }else{
                par[parB] = parA;
            }
        }
    public int makeConnected(int n, int[][] connections) {


        if(connections.length < n-1 ){
            return -1;
        }
        int component = n;
        par = new int[n];
        rank = new int[n];
        
        for(int i =  0 ; i  < n ; i++){
                par[i] = i;
            }

        for(int i = 0 ; i < connections.length ; i++){
            int a = connections[i][0];
            int b = connections[i][1];
            if(find(a) != find(b)){
                //need to add the components Union is required cause these are connected
                union(a , b);
                component--;
            }else{
                continue;
            }
        }

        return component-1;
    }
}
