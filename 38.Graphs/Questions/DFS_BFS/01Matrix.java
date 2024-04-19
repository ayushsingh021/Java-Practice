// Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

// The distance between two adjacent cells is 1.
// Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
// Output: [[0,0,0],[0,1,0],[1,2,1]]

class Solution {
    public class Point{
        int r ;
        int c ;
        int step;
        public Point(int r, int c , int s){
            this.r =r;
            this.c = c;
            this.step = s;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int delRow[] = {-1, 0 , 1, 0};
        int delCol[]= {0, 1 , 0 ,-1};
        int dist[][] = new int[m][n];
        boolean vis[][] = new boolean[m][n];
        Queue<Point> q = new LinkedList<>();

        for(int i = 0 ; i < m ; i ++){
            for(int j = 0 ;  j < n  ; j ++){
                if(mat[i][j] == 0){
                    //mark visited
                    q.add(new Point(i , j , 0));
                    vis[i][j] = true;
                }else{
                    //mark unvisited
                    vis[i][j] = false;
                }
            }
        } 
        //bfs
        while(!q.isEmpty()){
            int row = q.peek().r;
            int col = q.peek().c;
            int steps = q.peek().step;
            dist[row][col] = steps;
            q.remove();
            //seeing for all four drxn neighbours
            for(int i = 0 ; i < 4 ; i++){
                int newR = row + delRow[i];
                int newC = col + delCol[i];
                if(newR >= 0 && newR <m && newC >= 0 && newC <n && vis[newR][newC] == false){
                    //visited
                    vis[newR][newC] = true;
                    q.add(new Point(newR, newC ,steps +1));
                }
            } 
        }
        return dist;

    }
}