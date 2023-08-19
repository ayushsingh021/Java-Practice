// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

class Solution {
    public static List<Integer> generateRow(int row){
        List<Integer> rowlist = new ArrayList<>();
        rowlist.add(1);
        //imp optimum way to calculate a row of pascals triangle
        int ans=1;
        for(int col = 1 ; col < row ; col++){
        ans = ans * (row - col);
        ans = ans / col ;
        rowlist.add(ans);
        }
        return rowlist;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> anslt= new ArrayList<>();

        for(int  row  = 1  ; row <= numRows ; row++){
            anslt.add(generateRow(row));
        }
        return anslt;
    }
}