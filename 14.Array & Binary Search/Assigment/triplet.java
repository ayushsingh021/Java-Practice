import java.util.*;
public class triplet{
     public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int arr[]={-1,0,1,2,-1,-4};
    for(int i=0; i< arr.length-2 ; i++){
        for(int j=i+1; j<arr.length-1 ;j++){
            for(int k=j+1; k<arr.length ; k++){
                if(i!=j && i!=k && j!=k && arr[i]+arr[j]+arr[k]==0){
                  System.out.print(arr[i]+ " "+arr[j]+ " "+arr[k]+ " ");
                  System.out.println();
                }
            }
        }
    }
     System.out.println();
     sc.close();
    }
}