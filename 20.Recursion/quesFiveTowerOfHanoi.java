import java. util.*;
public class quesFiveTowerOfHanoi {

    public static void towerOfHanoi(int n , char src ,char dest, char help) {
        //base
        if(n==1){
            System.out.println("move disc " + n + " from " + src  + " to "+ dest );
             return;
            }

        //recursion
        towerOfHanoi(n-1, src, help, dest);  //step 1
        System.out.println("move disc " + n + " from " + src  + " to "+ dest );
        towerOfHanoi(n-1, help, dest, src); //step 2 
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt();
        char src = 'a' ; char help = 'b' ; char dest = 'c';
        towerOfHanoi(n, src, dest , help );
        sc.close();

    }
    
}
