// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Comparator<int[]> comparator = new Comparator<int[]>(){
            @Override
            public int compare(int row1[] ,int row2[]){
                return row1[0] - row2[0];
            }
        };
        //sorting
        Arrays.sort(intervals , comparator);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            int start  = intervals[i][0];
            int end  = intervals[i][1];

            //skip all merged intervals
            if(!ans.isEmpty() && end <= ans.get(ans.size()-1).get(1)){
                continue;
            }

            for(int  j = i+1; j< n ; j++){
                if(intervals[j][0] <= end ){
                    end = Math.max(end, intervals[j][1]);
                }else{
                    break;
                }
            }
            ans.add(Arrays.asList(start,end));

        }
        int ansArr[][] = new int[ans.size()][2];
        for(int i = 0 ;i < ans.size() ; i++){
            ansArr[i][0] = ans.get(i).get(0);
            ansArr[i][1] = ans.get(i).get(1);

        }
        return ansArr; 

    }
}