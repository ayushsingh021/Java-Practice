// There is one meeting room in a firm. There are N meetings in the form of (start[i], end[i]) where start[i] is start time of meeting i and end[i] is finish time of meeting i.
// What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held in the meeting room at a particular time?

// Note: Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.


// Example 1:

// Input:
// N = 6
// start[] = {1,3,0,5,8,5}
// end[] =  {2,4,6,7,9,9}
// Output: 
// 4
// Explanation:
// Maximum four meetings can be held with
// given start and end timings.
// The meetings are - (1, 2),(3, 4), (5,7) and (8,9)



Menu


Refresh

Time (IST)	Status	Lang	Test Cases	Code
2023-08-03 06:38:53	Correct	java	220 / 220	View
2023-08-03 06:30:48	Wrong	java	9 / 220	View
fab


class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        int meeting[][] = new int[n][3];
        for(int i = 0 ; i < n ; i ++){
            
            meeting[i][0]= i;
            meeting[i][1] = start[i];
            meeting[i][2] = end[i];
        }
        Arrays.sort(meeting , Comparator.comparingDouble( o->o[2]));
        int task = 1;
        int lastEnd = meeting[0][2];
        for(int i = 0 ; i < n ; i ++){
            if(meeting[i][1] > lastEnd){
                task++;
                lastEnd = meeting[i][2];
            }
        }
        return task;
    }
}