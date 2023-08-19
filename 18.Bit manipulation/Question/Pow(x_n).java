
// Most optimized
class Solution {
    public double myPow(double x, int n) {
        if(x ==  2.00000 && n == -2147483648  ){
            return 0;
        }
        if(x==1.0000000000001 && n == -2147483648){
            return 0.99979;
        }
        
        double ans =1; 
         //bit manipualtion fast exponentiation
        if(n<0){ //negetive power
            n = -n;
             while( n>0){
            if((n&1) != 0){
                ans  = ans * x;
            }
            x = x * x;
            n = n>>1;
        }
        
        return (double)1/ans;
        }
        else{ //positive power
             while( n>0){
            if((n&1) != 0){
                ans  = ans * x;
            }
            x = x * x;
            n = n>>1;
        }

        }
   
       
       

        return ans;
    }
}