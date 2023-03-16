public class gridWays {
   //*****Backtracking less optimized code  */
    // public static int gridWaysFind( int i, int j , int n ,int m){
    //     //base casee
    //     if(i == n-1 && j==m-1){ //condintion for last cell (edge)
    //         return 1;
    //     }else if(i==n || j== m ){ // condnfor boundary target cell
    //         return 0; 
    //     }

    //     int w1 = gridWaysFind(i+1, j, n, m);  //down choise
    //     int w2 = gridWaysFind(i, j+1, n, m);  //right choice

    //     return w1 + w2;
    // }

    //****more optiized code(Maths) :: T.C = O[n+m] (linear time) */
    public static int fact(int i){
        //basscase
        if(i==1){
            return 1;
        }
        int ans = i * fact(i-1);
        return ans;
    } 

    public static int gridPermuFind(int n, int m ){
        int totalWays = fact(n+m-2)/(fact(n-1) * fact (m-1)) ;
        return totalWays;
    }
    public static void main(String[] args) {
        int n =3; int m = 3;
        System.out.println(gridPermuFind(n, m));
        // System.out.println(gridWaysFind(0, 0, n, m));


    }
}
