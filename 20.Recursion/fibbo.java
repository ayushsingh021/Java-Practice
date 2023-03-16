import java.util.*;
public class fibbo{
    public static int Fibbo(int a){
        if(a==1){
            return 1 ;
        }
        else if(a==0){
            return 0;
        }
        int fib1 = Fibbo(a-1);
        int fib2 = Fibbo(a-2);
        int fib = fib1 + fib2;
        return fib;

    }
     public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    System.out.println(Fibbo(a));  
     System.out.println();
     sc.close();
    }
}