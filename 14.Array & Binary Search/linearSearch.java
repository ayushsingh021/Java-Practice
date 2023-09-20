import java.util.*;
public class linearSearch{
    public static void linearsearch(int no[], int key) {
        for(int i=0 ; i< no.length ; i++){
          if(no[i]==key){
            System.out.println(i);
          }
        }
        
    }
     public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int no[]= {2,4,5,6,7,10,11,3};
    int key =2;
   linearsearch(no, key); 
    

     sc.close();
    }
}