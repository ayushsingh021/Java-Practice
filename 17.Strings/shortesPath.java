import java.util.*;
public class shortesPath{
    public static float shortestPath(String drxn){
        int x=0 , y=0;
        for(int i=0; i< drxn.length();i++){
            int dir = drxn.charAt(i);
            //North
            if(dir=='N'){
                y++;
            }
            //south
            else if(dir == 'S'){
                y--;
            }
            //East
            else if(dir == 'E'){
                x++;
            }
            //west
            else{
                x--;
            }
        }
        int X2 =x*x;
        int Y2 =y*y;
        return (float)Math.sqrt(X2 + Y2);
    }
     public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String drxn = "WNEENESENNN";
    System.out.println(shortestPath(drxn));

     System.out.println();
     sc.close();
    }
}