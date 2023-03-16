import java.util.*;
public class Matrix{
    public static boolean elemSearch(int matrix[][] , int key){
        for(int i=0;i< matrix.length; i++){
            for(int j=0 ; j< matrix[0].length ;j++){
            if(matrix[i][j]==key){//found
                System.out.println("The cell of the element is "+ i +", " + j);
                return true;

            }               
            }
        }
        return false;
    }
     public static void main(String[] args) {
        int matrix[][] = new int [3][3];
        int n = matrix.length , m= matrix[0].length;
    Scanner sc = new Scanner(System.in);
    //input
    for(int i=0;i<n; i++){
        for(int j=0 ; j<m ;j++){
            matrix[i][j]= sc.nextInt();
        }
    }
    //output
    for(int i=0;i<n ;i++){
        for(int j=0; j<m; j++){
            System.out.print(matrix[i][j] + " ");
        }
        System.out.println();
    }
    //elem finding
    System.out.println("Enter the element to to find its cell");
    int key = sc.nextInt();
    elemSearch(matrix, key);
     System.out.println();
     sc.close();
    }
}