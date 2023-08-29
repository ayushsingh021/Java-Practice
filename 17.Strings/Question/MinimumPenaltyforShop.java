// 2483. Minimum Penalty for a Shop
// You are given the customer visit log of a shop represented by a 0-indexed string customers consisting only of characters 'N' and 'Y':

// if the ith character is 'Y', it means that customers come at the ith hour
// whereas 'N' indicates that no customers come at the ith hour.
// If the shop closes at the jth hour (0 <= j <= n), the penalty is calculated as follows:

// For every hour when the shop is open and no customers come, the penalty increases by 1.
// For every hour when the shop is closed and customers come, the penalty increases by 1.
// Return the earliest hour at which the shop must be closed to incur a minimum penalty.

// Note that if a shop closes at the jth hour, it means the shop is closed at the hour j.

 

// Example 1:

// Input: customers = "YYNY"
// Output: 2
// Explanation: 
// - Closing the shop at the 0th hour incurs in 1+1+0+1 = 3 penalty.
// - Closing the shop at the 1st hour incurs in 0+1+0+1 = 2 penalty.
// - Closing the shop at the 2nd hour incurs in 0+0+0+1 = 1 penalty.
// - Closing the shop at the 3rd hour incurs in 0+0+1+1 = 2 penalty.
// - Closing the shop at the 4th hour incurs in 0+0+1+0 = 1 penalty.
// Closing the shop at 2nd or 4th hour gives a minimum penalty. Since 2 is earlier, the optimal closing time is 2.

//brute 
    //     int penalty = Integer.MAX_VALUE;
    //     int idx = -1;
    //    for( int i = 0 ; i <= customers.length() ; i++){
    //        String strN = customers.substring(0,i);
    //        String strY = customers.substring(i);
    //         int N = countN(strN);
    //         int Y = countY(strY);

    //     int temp = N + Y;
    //     if( Y == customers.length()){
    //         return Y;
    //     }
    //     else if(N ==  customers.length() ){
    //         return 0;
    //     }
    //     if( temp < penalty){
    //         penalty = temp ;
    //         idx = i;
    //     }
    //    } 

   
    // public static int countN(String strN){
    //     int ans = 0;
        
    //     if(strN != ""){
    //         for(int i = 0 ; i < strN.length() ; i++){
    //         if(strN.charAt(i) == 'N'){
    //             ans++;
    //         }
    //        }
    //     }
    //     return ans;
    // }

    // public static int countY(String strY){
    //     int ans = 0;

    //     if(strY != ""){
    //           for(int i = 0 ; i < strY.length() ; i++){
    //         if(strY.charAt(i) == 'Y'){
    //             ans++;
    //         }
    //     }
    //     }
      
    //     return ans;
    // }


    //optimal --BEST
    class Solution {

   
        public int bestClosingTime(String customers) {
            int arrY[] = new int[customers.length() +1 ];
            int arrN[] = new int[customers.length() +1 ]; 
            int cnt = 0;
            //for N 
            arrN[0] =cnt;
            for(int i = 1 ; i < arrN.length ;  i++){
                if(customers.charAt(i-1) == 'N'){
                    cnt++;
                }
                arrN[i] = cnt ;
    
            }
            //for Y
            cnt= 0;
            arrY[arrY.length-1] =cnt;
            for(int i = customers.length()-1 ; i >= 0;  i--){
                if(customers.charAt(i) == 'Y'){
                    cnt++;
                }
                arrY[i] = cnt ;
    
            }
    
            int ans = Integer.MAX_VALUE;
            int idx = 0;
            for(int i = 0 ; i < arrY.length ; i++){
                int penalty  = arrY[i] + arrN[i];
                if(penalty < ans){
                    ans = penalty;
                    idx = i;
                }
    
            }
    
        
           return idx;
        }
    }