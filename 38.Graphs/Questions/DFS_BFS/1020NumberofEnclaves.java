// Same as surrounded regions

class Solution {

    public static void dfs(int[][] board, int m , int n , int r , int c , int[] delRow , int[] delCol ,boolean vis[][]){
       // board[r][c] = "O";
       vis[r][c] = true;
       for(int i = 0 ; i < 4 ; i++){
           int newR = r + delRow[i];
           int newC = c + delCol[i];
           if(newR <  m && newR >= 0 && newC <n && newC >= 0 ){
               if(board[newR][newC] == 1 && vis[newR][newC] == false){
                   dfs(board ,m , n , newR , newC, delRow, delCol , vis);
               }
           }
       }
       
   }

   public int numEnclaves(int[][] grid) {
       
        int delRow[] = {-1,0 ,1,0};
        int delCol[] = {0,1,0,-1};
       int m = grid.length;
       int n = grid[0].length; 

       
       boolean vis[][] = new boolean[m][n];
       //first row
       for(int j = 0 ; j < n ; j++){
               if(grid[0][j] == 1 && vis[0][j] == false){
                   dfs(grid,m , n , 0 , j , delRow , delCol ,vis);
               }
       }
       //first col
       for(int j = 0 ; j < m ; j++){
               if(grid[j][0] == 1 && vis[j][0] == false){
                   dfs(grid,m , n , j , 0 , delRow , delCol ,vis);
               }
       }

       //last row
       for(int j = 0 ; j < n ; j++){
               if(grid[m-1][j] == 1 && vis[m-1][j] == false){
                   dfs(grid,m , n , m-1 , j , delRow , delCol ,vis);
               }
       }

       //last col
       for(int j = 0 ; j < m ; j++){
               if(grid[j][n-1] == 1 && vis[j][n-1] == false){
                   dfs(grid,m , n , j , n-1 , delRow , delCol ,vis);
               }
       }
       
       int ans = 0;
       for(int  i = 0 ; i  < m  ; i++){
           for(int  j = 0;  j < n ;  j ++){
               if(vis[i][j] == false && grid[i][j] == 1){
                  ans++;
               }
           }
       }

       return ans;

   }
}