import java.util.*;  //it allows all libraray framework if it is there no need to write aladakore
// import java.util.Collection;

public class inbuiltSort{
    
    
    public static void printArr(Integer arr[]){
        for(Integer i=0 ; i<arr.length ;i++){
            System.out.print(arr[i]+ " ");
        }
    }
     public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Integer arr[]= {5,4,1,3,2};
    printArr(arr);//before
    System.out.println();
    Arrays.sort(arr,Collections.reverseOrder());
    printArr(arr);//after
    Arrays.sort(arr,0,3);//pehle 3 ka sorting only
     System.out.println();
     printArr(arr);
     sc.close();
    }
}