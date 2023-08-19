// You are given an m x n integer matrix matrix with the following two properties:

// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.

// You must write a solution in O(log(m * n)) time complexity.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m =matrix.length;
        int n = matrix[0].length;
        int lo = 0 ;
        int hi = (m*n) -1;
        while(lo <= hi){

            int mid = lo + (hi-lo)/2 ;
            if(matrix[mid/n][mid%n]== target){
                return true;
            }
            else if(matrix[mid/n][mid%n] < target){
                lo = mid+1;
            }
            else{
                hi = mid -1;
            }
        }
        return false;

    }
}