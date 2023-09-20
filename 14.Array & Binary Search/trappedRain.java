import java.util.*;
public class trappedRain{
    public static void printArr(int ht[]){
       for(int i=0 ; i<ht.length ; i++ ){
        System.out.print(ht[i]+ " ");
       }
    }
    public static void trappedRainwater(int height[]){
        int n = height.length;
     //finding left max array;
     int leftMax[]=new int[n];
     leftMax[0]=height[0];
     for(int i=1 ; i<n ; i++){
        leftMax[i]= Math.max(height[i], leftMax[i-1]);
     }
     printArr(leftMax); 


    //finding right max array;
    int rightMax[]= new int[n];
    rightMax[n-1]=height[n-1];
    for(int j=(n-2); j>=0 ; j--){
        rightMax[j]= Math.max(height[j], rightMax[j+1]);
    }
    System.out.println();
    printArr(rightMax);

    //loop taking min of them;
    int minWt[] = new int[n];
    for(int k=0 ; k<n ; k++){
        minWt[k] = Math.min( leftMax[k], rightMax[k]);
    }
    System.out.println();
    printArr(minWt);  
    //trappedwater = (min - barheight)*1  //1 is width of bar
    int SumWt = 0;
    int WtBar[]=new int[n];
    for(int a=0 ; a<n ; a++){
        WtBar[a] = (minWt[a]- height[a]);
        SumWt = SumWt + WtBar[a];
    }
    System.out.println();
    System.out.println("The volume of total trapped water is :" + SumWt);
    }
     public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int height[]= {4,2,0,6,3,2,5};
    trappedRainwater( height); 
    
    System.out.println();
    sc.close();
    }
}