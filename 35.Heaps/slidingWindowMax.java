import java.util.*;
public class slidingWindowMax {
    static class Point implements Comparable<Point>{
        int val;
        int idx;
        public Point(int val , int idx){
            this.val = val;
            this.idx = idx;
        }
        @Override
        public int compareTo(Point p2){
            return p2.val - this.val;
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        int ans[] = new int[n-k+1];
        //first window pairs
        for(int i = 0 ; i < k ; i++){
            pq.add(new Point(nums[i] , i));
        }
        ans[0] = pq.peek().val;
        
        for(int i = k ; i < n ; i++){
            while(pq.size() > 0 && pq.peek().idx <= (i-k)){
                pq.remove();
            }
            pq.add(new  Point(nums[i] , i));
            ans[i-k+1] = pq.peek().val;
        }
       
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {1,3,-1,3,5,3,6,7};
        int k = 3;
        int ans [] = maxSlidingWindow(nums,k);
        for(int i = 0 ; i < ans.length ; i++){
            System.out.print( ans[i] + " ");
        }
        

    }
}
