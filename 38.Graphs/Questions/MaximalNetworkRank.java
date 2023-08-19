// //There is an infrastructure of n cities with some number of roads connecting these cities. Each roads[i] = [ai, bi] indicates that there is a bidirectional road between cities ai and bi.

// The network rank of two different cities is defined as the total number of directly connected roads to either city. If a road is directly connected to both cities, it is only counted once.

// The maximal network rank of the infrastructure is the maximum network rank of all pairs of different cities.

// Given the integer n and the array roads, return the maximal network rank of the entire infrastructure.

//Input: n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]
// Output: 4
// Explanation: The network rank of cities 0 and 1 is 4 as there are 4 roads that are connected to either 0 or 1. The road between 0 and 1 is only counted once.
// T.C == O(V^2)

class Solution {
    public void graphCreate(ArrayList<Integer> graph[] , int roads[][]){
        for(int i = 0 ; i < roads.length ; i++){
            for(int j = 0 ; j < roads[0].length; j++){
                if( j == 0){
                    graph[roads[i][j]].add(roads[i][1]);
                }else{
                    graph[roads[i][j]].add(roads[i][0]);
                }
            }
        }
    }
    public int maximalNetworkRank(int n, int[][] roads) {
        ArrayList<Integer> graph[] = new ArrayList[n];
        for(int  i = 0 ; i < n ; i ++){
            graph[i] = new ArrayList<>();
        }
        graphCreate(graph , roads);
        int maxRank = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i ++){
            for(int  j = i+1 ;  j < n ; j++){
                int ranki =  graph[i].size();
                int rankj = graph[j].size();
                int totalRank = ranki + rankj;
                if(graph[i].contains(j) && graph[j].contains(i) ){
                    //cities are connected only oe time road should be count
                    totalRank = totalRank -1 ;
                }
                maxRank = Math.max(maxRank, totalRank);
            }
        }

        return maxRank;
    }
}