import java.util.*;
public class subString{
    public static String substr( String str , int si ,int ei ){
        String substr ="";
        for(int i =si ; i<ei ;i++){
            substr+= str.charAt(i);
        }
        return substr;
    }
     public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = "HelloWorld";
    System.out.println(substr(str, 0, 4));
     System.out.println();
     sc.close();
    }
}