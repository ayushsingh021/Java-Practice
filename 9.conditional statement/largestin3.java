import java.util.*;
public class largestin3{
     public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    
    // if(a>b){
    //     if(a>c){
    //         System.out.println("The largest no. is" + a);
    //     }
    //     else{
    //         System.out.println("The largest no. is"+ c);
    //     }
    // }
    // else if(b>c){
    //     if(b>a){
    //         System.out.println("the largest no. is "+ b);
    //     }
    //     else{
    //         System.out.println("The largest no is "+ a);
    //     }
    // }
    // else if(c>a){
    //     if(c>b){
    //         System.out.println("the largest no. is "+ c);
    //     }
    //     else{
    //         System.out.println("The largest no is "+ b);
    //     }
    // }  //working but not good space complexity
    
    if(a>=b && a>=c){
        System.out.println("The largest no is"+ a);
    }
    else if(b>=c){
        System.out.println("The largest no is " +b);
    }
    else{
        System.out.println("The largest no. is "+ c);
    }

     System.out.println();
     sc.close();
    }
}
