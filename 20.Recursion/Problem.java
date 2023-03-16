import java.util.*;
public class Problem{
    //Solved by recursion
    public static void printDec(int n){
        if(n==1){
           System.out.println(n);
           return;
        }
        System.out.print( n + " ");
        printDec(n-1);

    }

    public static void printInc(int n){
        if(n==1){
            System.out.print(n + " ");
            return;
        }
        printInc(n-1);
        System.out.print(n + " ");
    }
     public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
     System.out.println();
     int n =10;
     printDec(n);
     printInc(n);
     sc.close();

    }
}