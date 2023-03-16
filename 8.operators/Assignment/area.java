import java.util.*;
public class area{
     public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the side");
    int side = sc.nextInt();

    int area = side * side ;

     System.out.println("The area of square "+ area);
     sc.close();
    }
}