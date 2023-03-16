import java.util.*;
public class impStringbuild{
     public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder(""); //initiate
    for(char ch ='a' ; ch<= 'z' ; ch++){
        sb.append(ch);
    }
    System.out.println(sb);
    System.out.println(sb.length());

     System.out.println();
     sc.close();
    }
}