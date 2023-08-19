// // You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

// // You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[7,4,1],[8,5,2],[9,6,3]]

class Solution {
    public static void reverseRow(int[][] matrix, int row){
        int n  = matrix.length;
        for(int i  = 0 ; i < matrix.length/2 ; i++){
            int temp = matrix[row][i];
            matrix[row][i] = matrix[row][n-1-i];
            matrix[row][n-1-i] = temp;
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
     //step 1 : Transpose a matrix
    for(int i = 0 ; i < n - 1; i++){
         for(int j = i + 1 ;  j  < n ; j++){
             //swap
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
         }
    }
    //Reverse the row
    for(int i = 0 ; i < n ; i++){
        reverseRow(matrix, i);
    } 
    //  for(int i = 0 ; i < n ; i++){
    //      for(int j = 0 ;  j  < n ; j++){
    //          System.out.print(matrix[i][j] + " ");
    //      }
    //      System.out.println();
    // }  
    }
}