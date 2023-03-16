public class friendPair {
    
    public static int pairWays(int n){
        //base case
        if(n==1|| n==2){
            return n;
        }
        //kaam
        //choice single
        int ch1 = pairWays(n-1);
        //pairing
        int ch2 =  pairWays(n-2);
        int pairway = (n-1)* ch2;
        int totalWays = ch1 + pairway;
        return totalWays; 
    }
    public static void main(String[] args) {
        System.out.println( pairWays(4));
       
    }
}
