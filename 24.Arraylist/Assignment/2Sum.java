class Solution {
    public int[] twoSum(int[] nums, int target) {
     int j = nums.length-1;
     int i=0;
     int arr[][] = new int[nums.length][2];
     for(int k = 0 ; k <nums.length ; k++){
         arr[k][0] = k;
         arr[k][1] = nums[k];
     }
     Arrays.sort(arr , Comparator.comparing(o -> o[1]));
  while(arr[i][1] + arr[j][1] != target){
      if(arr[i][1] + arr[j][1] > target){
          j--;
      }else{
          i++;
      }
  }
  
  return new int[] {arr[i][0],arr[j][0]};


 }
}


