class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q  = new LinkedList<>();
        for(int i = 1; i < 9 ; i++){
            q.add(i);
        }
        while(!q.isEmpty()){
            int num = q.remove();
            if(num > high){
                break;
            }
            if(num >= low && num <= high){
                ans.add(num);
            }
            int endDig = num%10;
            if(endDig != 9 && num < high){
                  int digAppend =endDig+1;
                  num = num*10 + digAppend;
                  q.add(num);
            }
        }
        return ans;
    }
}
