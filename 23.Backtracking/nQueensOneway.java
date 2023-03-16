public class nQueensOneway {
    public static void PrintBoard(char Board[][]){
        System.out.println("***********Chess board**************");
        for (int i= 0 ;i <Board.length ; i++){
            for(int j=0; j<Board.length;j++){
                System.out.print(Board[i][j]+ " ");
            }
            System.out.println();
        }
    }
    public static boolean isSafe(char Board[][], int row , int col){
        //vertial
        for(int i = row -1 ; i >=0;i--){
            if(Board[i][col] == 'Q'){
                return false;
            }
        }
        //left diagonal
        for(int i = row -1 ,j =col-1 ; i>=0 && j>= 0 ; i-- , j--){
            if(Board[i][j]== 'Q'){
                return false;
            }
        }
        //right diagonal
        for(int i =row - 1 , j =col +1 ; i>=0 && j<Board.length ; i-- ,j++){
            if(Board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

    public static boolean nQueensSol(char Board[][], int row ){
        //base
        if(row==Board.length){
            // PrintBoard(Board);
            return true;
        }

        //recursion
        //coloumn loop
        
        for(int j=0 ; j<Board.length; j++ ){
            if(isSafe(Board,row,j)){
                Board[row][j]='Q';
            if(nQueensSol(Board, row+1)){
                return true;
            }
            Board[row][j]= 'x';
            }
             //backtracking
        }
        return false;
    
    }

    public static void main(String[] args) {
        int n =4;
        char Board[][] = new char [n][n];

        //initilize
        for(int i= 0 ; i< n ;i++){
            for (int j=0 ; j<n ; j++){
                Board[i][j] = 'x';
            }
        }
        if(nQueensSol(Board,0)){
            System.out.println("Atleast one solutiom exist");
            PrintBoard(Board);
        }else{
            System.out.println("Solution is not possible");
        }


    }
}
