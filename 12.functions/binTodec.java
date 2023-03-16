import java.util.*;
public class binTodec{
    public static int BinDeci(int n){
        int dec =0;
        for(int i =0 ; n>0 ; i++){
            int dig = (n%10);
            dec = dec + (dig * (int)Math.pow(2, i)); // as math.pow convert in double we need to type cast
            n=(n/10);

        }
        return dec;
    }
     public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
     System.out.println("Enter the binary number");
     int n = sc.nextInt();
     System.out.println("The decimal no is "+ BinDeci(n));
     
     sc.close();
    }
}