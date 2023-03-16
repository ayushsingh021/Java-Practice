import java.util.*;
public class numberReverse{
     public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int digit;
    int ans=0;
    
    while(n>0){
          digit = n%10;
          ans = (ans * 10) + digit;
          n=(n/10);
    }
     System.out.println(ans);
     sc.close();
    }
}
