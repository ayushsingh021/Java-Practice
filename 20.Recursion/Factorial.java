import java.util.*;
public class Factorial{

    public static int factorial(int a){
        if(a==0){
            return 1;
        }
        int fnm1 =  factorial(a-1);
        int fnm= a *factorial(a-1);
        return fnm;
    }
     public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    System.out.println( factorial(a));
     sc.close();
    }
}