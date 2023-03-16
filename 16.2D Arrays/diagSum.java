import java.util.*;
public class diagSum{
    public static void diagonalSum(int matrix[][]){
        int sum=0;
        //This is bruteforce method T.C =O(n^2)
        // for(int i=0; i<matrix.length; i++){
        //     for(int j=0; j< matrix[0].length; j++){
        //         if( i == j){
        //             sum= sum + matrix[i][j];
        //         }
        //         else if(i+j == (matrix.length-1)){
        //             sum= sum + matrix[i][j];
        //         }
        //     }
        // }
        // System.out.println(sum);

      //Optimized method  O(n)
      for(int i=0; i< matrix.length ;i++){
        //prim diag
        sum+= matrix[i][i];
        //sec diag
        if(i!= matrix.length-1-i){
        sum+= matrix[i][matrix.length-1-i];
        }
      }
     System.out.println(sum);

    }
     public static void main(String[] args) {
        int matrix[][]= {{1, 2, 3, 4},
                       {5, 6, 7, 8},
                       {9, 10, 11, 12},
                       {13, 14, 15, 16}};
    Scanner sc = new Scanner(System.in);
    diagonalSum(matrix);
     System.out.println();
     sc.close();
    }
}