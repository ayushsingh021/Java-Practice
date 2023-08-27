public class fibbonacchiDp {
    // public int fib(int a) {
    //     //basecase
    //     if(a==1 || a == 0){
    //         return a ;
    //     }
    //     int fib1 = fib(a-1);
    //     int fib2 = fib(a-2);
    //     int fibo = fib1 + fib2;
    //     return fibo;
    // }

    //dp approach -- Memoization
    public static int fibbo(int a ,int f[]){
        if(a == 1 || a == 0){
            return a;
        }
        if(f[a] != 0){
            return f[a];
        }
        f[a] = fibbo(a-1 ,f) + fibbo(a-2,f);
        return f[a];

    }

    public static int fibboTabulation(int a ){
        int dp [] = new int[a+1];
        dp[0] = 0;
        dp[1] =1 ;
        for(int i = 2; i < dp.length ;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[a];
        
    }
    public static void main(String[] args) {
        int a = 5 ;
        int f[] = new int[a+1];
        // System.out.println(fibbo(a, f));
        System.out.println(fibboTabulation(a));
         
    }

}