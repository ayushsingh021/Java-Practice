// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

// You must do it in place.
// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

class Solution {
    public static void markRow(int[][] matrix,int i){
        //used a for marking cuz negetive nos may exist so -1 not used
        for(int k = 0 ; k < matrix[0].length ; k++){
            if(matrix[i][k] != 0 ){
                matrix[i][k] = (int)'a';
            }
        }
    }
     public static void markCol(int[][] matrix,int j){
        for(int k = 0 ; k < matrix.length ; k++){
            if(matrix[k][j] != 0 ){
                matrix[k][j] = (int)'a';
            }
        }
    }
    public void setZeroes(int[][] matrix) {
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j  = 0 ; j < matrix[0].length ; j++){
                if(matrix[i][j] == 0){
                    markRow(matrix , i);
                    markCol(matrix , j);
                }
            }
        }
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j  = 0 ; j < matrix[0].length ; j++){
                if(matrix[i][j] == (int)'a'){
                  matrix[i][j] = 0;
                }
            }
        }
        

    }
}