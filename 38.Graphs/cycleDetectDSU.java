class Solution
{
    //Function to detect cycle using DSU in an undirected graph.
   
       
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

    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {   
        
        if(V == 2) return 0;
        par = new int[V];
        rank = new int[V];
        
        for(int i =  0 ; i  < V ; i++){
                par[i] = i;
            }
        
        for(int i = 0 ; i  < V ; i++){
            int src = i;
            
            for(int  j = 0; j < adj.get(i).size() ; j++){
                int dest = adj.get(i).get(j);
                
                if(dest  > src){
                    
                    int parS= find(src);
                    int parD = find(dest);
                    
                    if(parS == parD){
                        return 1;
                    }else{
                        union(parS , parD);
                    }
                    
                }
            }
        }
        
        return 0;
       
    }
}