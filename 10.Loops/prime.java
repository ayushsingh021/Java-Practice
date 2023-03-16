import java.util.*;
public class prime{
     public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number ");
    int n= sc.nextInt();

    boolean isPrime = true;
    if(n==2){
        System.out.println("It is prime");
    }
    else{

        for(int i=2 ; i<=Math.sqrt(n); i++){
            if((n%i)==0){
                isPrime = false;
            }
        }
        if(isPrime==true){
            System.out.println("it is Prime");
        }
        else{
            System.out.println("It is not prime");
        }
         
    }
 
     sc.close();
    }
}