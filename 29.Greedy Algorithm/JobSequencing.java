import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class JobSequencing {
    
    static class Jobs{
        int profit;
        int deadline;
        int id; //idx
        public Jobs(int i, int d , int p ){
            id = i ;
            deadline = d;
            profit = p;
        }
    }
    public static void main(String[] args) {
        int jobInfo[][] = {{4,20} , {1,10} , {1,40 } , {1,30} };

        ArrayList<Jobs> jobs = new ArrayList<>();  //we initailized the object for Jobs class which is AL type
        for(int  i =  0 ;  i < jobInfo.length ; i++){ //obj creation
            jobs.add(new Jobs(i, jobInfo[i][0] , jobInfo[i][1]));
        } 
        //sorting of objects (Learn)
        Collections.sort(jobs , (obj1,obj2)  -> obj2.profit - obj1.profit); //decrnding order

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for(int i = 0 ; i< jobs.size() ;i++){
            Jobs curr = jobs.get(i);
            if(curr.deadline > time){ //we can do that work
                time++;
                seq.add(curr.id);
            }
        }
        //print seq
        System.out.println("Max jobs can be done " + seq.size());
        for(int  i = 0 ; i < seq.size() ; i++){
            System.out.print(seq.get(i) + " ");
        }
        System.out.println();

    }
}
