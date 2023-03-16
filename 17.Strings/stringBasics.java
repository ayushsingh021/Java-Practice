import java.util.*;
public class stringBasics{
     public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // String name;
    // name = sc.next();
    // name =sc.nextLine();
    // System.out.println(name);
    // System.out.println(name.length());

    //concatenation
    String firstName = "Ayush";
    String lastName = "Singh";
    String fullName = firstName + " " + lastName;
    System.out.println(fullName);
    System.out.println(fullName.charAt(6));

     System.out.println();
     sc.close();
    }
}