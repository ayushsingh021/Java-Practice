// Given a set of N jobs where each jobi has a deadline and profit associated with it.

// Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit associated with job if and only if the job is completed by its deadline.

// Find the number of jobs done and the maximum profit.

// Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job.


// Example 1:

// Input:
// N = 4
// Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}
// Output:
// 2 60
// Explanation:
// Job1 and Job3 can be done with
// maximum profit of 60 (20+40).



class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
       int ans[] = new int[2];
       Arrays.sort(arr , (a,b) -> (b.profit - a. profit));

       
       int max= Integer.MIN_VALUE;
       for(int i = 0 ; i < n ; i++){
           if(arr[i].deadline > max){
               max = arr[i].deadline;
           }
       }
       
       int jobSeq[] = new int[max+1];
       for(int i = 1; i<= max ; i++ ){
           jobSeq[i]= -1;
       }
       
       int count = 0 ; int profitAns= 0;
       for(int  i = 0  ; i  < n ; i++){
           
           for(int j = arr[i].deadline ; j>0 ; j--){
                if( jobSeq[j] == -1){ //slot is free
                    jobSeq[j] = i;
                    count++;
                    profitAns += arr[i].profit;
                    break;
                }   
           }
       }
       
       ans[0] = count;
       ans[1] = profitAns;
       
       return ans;
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/