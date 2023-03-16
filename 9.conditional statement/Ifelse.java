import java.util.*;
public class Ifelse{
     public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter your age");
    int age = sc.nextInt();
    if(age >=18 ){
        System.out.println("you are adult");
        }
    else if(age<18 && age>=13){
        System.out.println("you are a teenager");
    }
    else{
        System.out.println("you are kid");
    }
     sc.close();
    }
}