import java.util.*;
public class subArrSumOfK {
    public static void main(String[] args) {
        int nums[] = {10,2,-2,-20,10};
        int k = -10;
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        //(sum ,count)
        hm.put(0,1);
        int sum= 0;
        int ans=0;
        for(int j = 0 ; j < n ; j++){
            sum += nums[j];
            if(hm.containsKey(sum - k )){
                ans = ans + hm.get(sum-k);
            }
            hm.put(sum , hm.getOrDefault(sum, 0)+1);
        }
        System.out.println("The no of subaarays having sum k " + ans);
    }
}
