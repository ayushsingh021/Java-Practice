// You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

// Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

// Return intervals after the insertion.

 

// Example 1:

// Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
// Output: [[1,5],[6,9]]
// Example 2:

// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
// Output: [[1,2],[3,10],[12,16]]
// Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].


class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        while(i < intervals.length){
            if(intervals[i][1] < newInterval[0]){
                //end of intrvl in less than start of newintrvl
                ans.add(Arrays.asList(intervals[i][0] , intervals[i][1]));

            }
            else if(intervals[i][0] > newInterval[1]){ // start of interval is greater than newintr end
                break;
            }
            else{
                //merge
                newInterval[0] = Math.min(newInterval[0]  , intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1]  , intervals[i][1]);
            }
            i++;
        }
         ans.add(Arrays.asList(newInterval[0] , newInterval[1]));

        while(i < intervals.length){
            ans.add(Arrays.asList(intervals[i][0] , intervals[i][1]));
            i++;
        }


        
          int ansArr[][] = new int[ans.size()][2];
        for(int j = 0 ;j< ans.size() ; j++){
            ansArr[j][0] = ans.get(j).get(0);
            ansArr[j][1] = ans.get(j).get(1);

        }
        return ansArr; 
    }
}