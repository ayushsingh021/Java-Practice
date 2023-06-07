import java.util.*;
public class ActivitySelection{
  public static void main(String[] args) {
    int start[] = {3,1,0,5,5,8};
    int end[] = {4,2,6,7,9,9};

    //sorting  (incase the ned is not given sorted already in ques)
    int activities[][] = new int[start.length][3]; //3 things need to be stored idx, start, end cause after we sort we nedd to retrieve the idx 
    
    for(int i = 0 ; i< start.length; i++ ){
        activities[i][0] = i;
        activities[i][1] = start[i];
        activities[i][2] = end[i];
    }
    // lambda funtion -- shortform (sorts the specicific col eg: 2  of a 2d array)
    Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
    // for(int i=0 ; i<start.length ; i ++){
    //     System.out.println(activities[i][0] + "&" + activities[i][2]);
    // }

    int maxAct =0;
    ArrayList<Integer> ans = new ArrayList<>();
    //as end time is sorted so at end[0] we will get most quick finishing work
    
    //first activity
    maxAct = 1;
    ans.add(activities[0][0]);

    int lastEnd = activities[0][2];
    for(int i =0 ;i<end.length ; i++){
        if(activities[i][1] >= lastEnd){
            maxAct++;
            ans.add(activities[i][0]);
            lastEnd = activities[i][2];
        }
    }
    System.out.println("Maximum activity can be done " + maxAct);
    for(int i = 0 ; i < ans.size() ; i++ ){
            System.out.print( "A"+ans.get(i) + " ");
    }
  }
}