public class PowerOfTwo {

    public static boolean isPowerOfTwo(int n){
        return (n&(n-1)) == 0;
    }
    public static void main(String[] args) {
        if(isPowerOfTwo(8)){
            System.out.println("No. is a power of two");
        }else{
            System.out.println("Not a power of two");
        }
    }
    
}
