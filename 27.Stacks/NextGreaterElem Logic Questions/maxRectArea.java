import java.util.*;
public class maxRectArea {
    public static void nextSmallerLeft(int [] heights , int [] arr){
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i<heights.length ; i++){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                arr[i] = -1;
            }else{
                arr[i] = s.peek();
            }
            s.push(i);
        }

    }
     public static void nextSmallerRight(int [] heights , int [] arr){
        Stack<Integer> s = new Stack<>();
        for(int i = heights.length-1; i>=0 ; i--){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                arr[i] = heights.length;
            }else{
                arr[i] = s.peek();
            }
            s.push(i);
        }

    }
    public static int maxArea(int [] area){
        int mx = Integer.MIN_VALUE;
        for(int i = 0 ; i < area.length ; i++){
            if(area[i] > mx){
                mx = area[i];
            }
        }
        return mx;
    }
    
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        //nextsmallerleft
        int nsl[] =  new int[n];
        nextSmallerLeft(heights,nsl);
        // for(int i = 0 ; i<nsl.length ; i++){
        //     System.out.print(nsl[i] + " ");
        // }
        //nextsmallerright
        int nsr[] = new int[n];
        nextSmallerRight(heights,nsr);
        // for(int i = 0 ; i<nsr.length ; i++){
        //     System.out.print(nsr[i] + " ");
        // }
        int area[] = new int [n];
        for(int i = 0 ; i < n ; i++){
            area[i] = heights[i] * ( nsr[i] - nsl[i] -1);
        } 
        return maxArea(area);
    }
    public static void main(String[] args) {
        int heights[] = {2,1,5,6,2,3}; 
        System.out.println(largestRectangleArea(heights));
    }
    
}
