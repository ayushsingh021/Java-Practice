import java.util.*;
public class PrimeinRange{

    public static boolean isPrime(int j){
      for(int i=2; i<= Math.sqrt(j) ;i++){
        if((j%i)==0){
            return false;
        }
      }
      return true;

    }
    public static void primeRange(int n){
      for(int i=2 ; i<=n ; i++){
        isPrime(i);
        if(isPrime(i)== true){
            System.out.print(i + ", ");
        }
      }
    }

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
     System.out.println("Enter the range: ");
     int n =sc.nextInt();
     System.out.println("the prime nos in range are");
     primeRange(n);


     sc.close();
    }
}