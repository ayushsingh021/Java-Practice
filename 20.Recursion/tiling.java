public class tiling {

    public static int tilWays(int n){
        //base case
        if(n==0 || n==1){
            return 1;
        }
        //kaam
        //vertical choice
        int fnm1 = tilWays(n-1);
        //horizonatal choice
        int fnm2 = tilWays(n-2);

        //total
        int totalWays = fnm1+fnm2;
        return totalWays;
    }
    public static void main(String[] args) {
        System.out.println(tilWays(6));
    }
}
