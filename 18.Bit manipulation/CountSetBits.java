public class CountSetBits {

    public static int setBitCount(int n){
        int count = 0;
        while(n>0){
           int lsb = n&1;
           if(lsb==1){
            count++;
           }
           n = (n>>1);

        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(setBitCount(15));
    }
    
}
