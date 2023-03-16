import java.util.*;
public class palindrome{
     public static int same (int n){
        int ans = 0;
        while (n>0 ){
        int dig = (n%10);
        ans = (ans*10) + dig;
        n = n/10;
    }
    return ans;

  }
  public static int reverse (int n){
    int ans = 0;
    int i =0;
    while (n>0 ){

    int dig = (n%10);
    ans = (dig * (int)Math.pow(10,i)) + ans;
    i++;
    n = n/10;
}
return ans;

}
     public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
     System.out.println("enter the number ");
     int n = sc.nextInt();
     int a = same(n);
     int b = reverse(n);
     if(a==b){
        System.out.println("The number is palindrome");
     }
     else{
        System.out.println("The number is not palidrome");
     }
     sc.close();
    }
}