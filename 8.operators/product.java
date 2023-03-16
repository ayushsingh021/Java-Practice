import java.util.Scanner;
public class product{
     public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter the numbers ");
     int a = sc.nextInt();
     int b = sc.nextInt();
     int product = a*b ;
        System.out.print("The value of product is ");
        System.out.println(product);
    sc.close();
    }
}