// // Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

// // A region is captured by flipping all 'O's into 'X's in that surrounded region.
// Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
// Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
// Explanation: Notice that an 'O' should not be flipped if:
// - It is on the border, or
// - It is adjacent to an 'O' that should not be flipped.
// The bottom 'O' is on the border, so it is not flipped.
// The other three 'O' form a surrounded region, so they are flipped.
// Example 2:

// Input: board = [["X"]]

// Output: [["X"]]


//basically border "O" se hum jis jis O tak jaa skate hai wo rahega baki sab flip hoke X ho jaiga-- question

class Solution {
    public static void dfs(char[][] board, int m , int n , int r , int c , int[] delRow , int[] delCol ,boolean vis[][]){
        // board[r][c] = "O";
        vis[r][c] = true;
        for(int i = 0 ; i < 4 ; i++){
            int newR = r + delRow[i];
            int newC = c + delCol[i];
            if(newR <  m && newR >= 0 && newC <n && newC >= 0 ){
                if(board[newR][newC] == 'O' && vis[newR][newC] == false){
                    dfs(board ,m , n , newR , newC, delRow, delCol , vis);
                }
            }
        }
        
    }
    public void solve(char[][] board) {
        
         int delRow[] = {-1,0 ,1,0};
         int delCol[] = {0,1,0,-1};
        int m = board.length;
        int n = board[0].length; 

        
        boolean vis[][] = new boolean[m][n];
        //first row
        for(int j = 0 ; j < n ; j++){
                if(board[0][j] == 'O' && vis[0][j] == false){
                    dfs(board,m , n , 0 , j , delRow , delCol ,vis);
                }
        }
        //first col
        for(int j = 0 ; j < m ; j++){
                if(board[j][0] == 'O' && vis[j][0] == false){
                    dfs(board,m , n , j , 0 , delRow , delCol ,vis);
                }
        }

        //last row
        for(int j = 0 ; j < n ; j++){
                if(board[m-1][j] == 'O' && vis[m-1][j] == false){
                    dfs(board,m , n , m-1 , j , delRow , delCol ,vis);
                }
        }

        //last col
        for(int j = 0 ; j < m ; j++){
                if(board[j][n-1] == 'O' && vis[j][n-1] == false){
                    dfs(board,m , n , j , n-1 , delRow , delCol ,vis);
                }
        }
        
        for(int  i = 0 ; i  < m  ; i++){
            for(int  j = 0;  j < n ;  j ++){
                if(vis[i][j] == true){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }

        
    }
}
 