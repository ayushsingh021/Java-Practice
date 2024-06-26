//VVI Imp

// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

// Input: n = 4
// Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
class Solution {
    public static boolean isSafe(char board[][] , int row, int col){
        //Vertical
        for( int i = row - 1; i>= 0 ; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        //leftdiag
        for(int i = row-1 , j= col -1; i>=0 && j >=0 ; i-- ,j--){
            if(board[i][j]== 'Q'){
                return false;
            }
        }

        //rightdiag
         for(int i = row-1 , j= col + 1; i>=0 && j < board.length; i-- ,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
   static List<String> construct(char[][] board) {

        List<String> internal = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String row = new String(board[i]);
            internal.add(row);
        }
        return internal;
    }

    public static void nQueenSol(char board[][] , int row , List<List<String>> ans){
        //base case
        if(row == board.length){
            ans.add(construct(board));
            return;
        }
        //column loop
        for(int j = 0 ; j < board.length ; j++){
            if(isSafe(board, row , j )){
                board[row][j] = 'Q';
                nQueenSol(board , row+1,ans);   
                board[row][j] = '.'; //backtracking
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char [n][n];

        for(int i = 0 ; i  < n ; i++){
            for(int j = 0 ;  j  < n ; j ++ ){
                board[i][j] = '.';
            }
        }
        List<List<String>> ans =new ArrayList<>();
        nQueenSol(board , 0 ,ans);
        return ans;
    }
}