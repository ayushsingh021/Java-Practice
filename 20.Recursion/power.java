public class power {
    // public static int toThePow(int base , int pow) {
    //     if(pow==1){
    //         return base;
    //     }
    //     int fn1 = base* toThePow(base, pow-1);
    //     return fn1;
    // }

    //*******Optimized solution********/
    public static int toThePow(int base , int pow) {//O(logn)
        if(pow == 0){
            return 1;
        }
        int halfPower = toThePow(base, pow/2);
        int halfPowerSq = halfPower * halfPower;
        //if pow is odd
        if(pow %2 !=0){
            halfPowerSq = base * halfPowerSq;
        }

        return halfPowerSq;
    }
    public static void main(String[] args) {
        int base = 2;
        int pow = 5;
        System.out.println("Power of the "+toThePow(2,10));
        
    }
}
