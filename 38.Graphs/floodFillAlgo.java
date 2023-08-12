public class floodFillAlgo {
    
    public static void helper (int[][] image,int[][] ans , int row, int col, int color,int orgCol,int delRow[],int delCol[]){
        //dfs algo
        ans[row][col] = color;
        int m = image.length;
        int n = image[0].length;
        for(int i = 0 ; i < 4 ; i++){
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];
            if(newRow >= 0 && newRow<m && newCol >=0 && newCol <n && image[newRow][newCol] == orgCol && ans[newRow][newCol] != color ){
                helper(image,ans ,newRow ,newCol,color, orgCol , delRow , delCol);
            } 

        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans = image; //copy array dont tamper original data
        int orgCol = image[sr][sc];
        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};

        helper(image, ans , sr, sc, color, orgCol , delRow , delCol);
        return ans; 
    }
    public static void main(String[] args) {
        int image[][] = {{1,1,1},
                        {1,1,0},
                        {1,0,1}};
        int sr = 1, sc = 1, color = 2;
        int ans[][] = floodFill(image ,sr,sc,color);
        
        for(int i = 0 ; i  < ans.length ;i++){
            for(int  j = 0 ; j < ans[0].length ; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
