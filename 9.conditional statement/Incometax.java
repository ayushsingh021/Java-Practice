import java.util.*;
public class Incometax{
     public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter your Income");
    float I = sc.nextFloat();
    float tax;
    
    if(I<500000){
        System.out.println("No payable tax");
    }
    else if(I>=500000 && I<= 1000000){
        tax = (float)(I*0.2) ;
        System.out.println("Payable tax is"+ tax);

    }
    else{
        tax = (float)(I*0.3) ;
        System.out.println("Payable tax is" + tax);
    }

     
     sc.close();
    }
}
