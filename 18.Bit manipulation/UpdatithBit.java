public class UpdatithBit {
    public static int setithBit(int n , int i){
        int bitmask =  (1<<i);
        return n|bitmask;
    }

    public static int clearithBit(int n , int i){
        int bitmask =  ~(1<<i);
        return n&bitmask;
    }

    public static int updateithBit(int n , int i , int newBit){
        //method 1
        // if(newBit == 0){
        //     return clearithBit(n, i);
        // }else{
        //     return setithBit(n, i);
        // }
        //method2
         n = clearithBit(n,i);
         int bitmask = newBit<<i;
         return n|bitmask;
    }
    public static void main(String[] args) {
        System.out.println(updateithBit(10, 2 , 1));
    }
}
