
import java.util.*;
public class shortestPath{
    public static int countChar(String drxn , char A){
        int count =0;
        for(int i = 0 ; i<drxn.length() ; i++ ){
            if(drxn.charAt(i)== A){
                count+=1;
            }
        }
        return count;
        }
    public static void shortPath(String drxn){
        int north = countChar(drxn, 'N');
        System.out.println(north);
        int south = countChar(drxn, 'S');
        int west = countChar(drxn, 'W');
        int east = countChar(drxn, 'E');
        int x = (east - west), y =(north-south);
        int X2 = x*x ,Y2 = y*y;
        System.out.println(Math.sqrt(X2 + Y2));

    }    
     public static void main(String[] args) {
        String drxn = "WNEENESENNN";
    Scanner sc = new Scanner(System.in);
    shortPath(drxn);
     System.out.println();
     sc.close();
    }
}