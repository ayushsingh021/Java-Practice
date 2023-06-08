public class ClearRangeofBits{

    public static int clearRange(int n , int i , int j){
        int a = (~0)<<(j+1);
        int b = (1<<i)-1;
        // int b = ~((~0)<<i); //it also works

        int bitmask = a|b;
        return n&bitmask;
    }
    public static void main(String[] args) {
       
        System.out.println( clearRange(10, 2, 4));
    }
}