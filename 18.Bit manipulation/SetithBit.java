public class SetithBit {
    public static int setithBit(int n , int i){
        int bitmask =  (1<<i);
        return n|bitmask;
    }
    public static void main(String[] args) {
        System.out.println(setithBit(10, 2));
    }
    
}
