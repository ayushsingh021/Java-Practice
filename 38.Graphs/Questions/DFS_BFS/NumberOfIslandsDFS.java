// public 200. Number of Islands
// Solved
// Medium
// Topics
// Companies
// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

// Example 1:

// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1
// Example 2:

// Input: grid = [
//   ["1","1","0","0","0"],
//   ["1","1","0","0","0"],
//   ["0","0","1","0","0"],
//   ["0","0","0","1","1"]
// ]
// Output: 3 {
    
// }

// Pattern 

class Solution {
    public static void dfs(char[][] grid , int r , int c , int[] delRow , int [] delCol, boolean [][] vis , int m ,int n){
        vis[r][c] = true;

        for(int i = 0 ; i  < 4  ; i++){
            int newR = r + delRow[i];
            int newC = c + delCol[i];
            if(newR >= 0 && newR < m && newC >=0 && newC < n ){
                if(grid[newR][newC] == '1' && !vis[newR][newC]){
                    dfs(grid, newR, newC , delRow, delCol, vis , m , n);
                }
            }

        }

    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean vis[][] = new boolean[m][n];

        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};
        int ans = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    ans++;
                    dfs(grid , i , j , delRow, delCol ,vis , m , n );
                }
            }
        }

        return ans;
    }
}