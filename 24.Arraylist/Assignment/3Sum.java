// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.

// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Explanation: 
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
// The distinct triplets are [-1,0,1] and [-1,-1,2].
// Notice that the order of the output and the order of the triplets does not matter.

class Solution {
    //Hashing approach
     // public List<List<Integer>> threeSum(int[] nums) {
     //     int n = nums.length;
     //     System.out.println(n);
     //     HashSet<Integer> set = new HashSet<>();
     //     List<List<Integer>> ans = new ArrayList<>();
     //     for(int i=0; i < n ; i++){
     //         for(int j = i+1 ; j < n ; j++){
     //             int sum = -(nums[i] + nums[j]);
     //             if(set.contains(sum)){
     //                 List<Integer> sortedList = new ArrayList<>(Arrays.asList(nums[i], nums[j], sum));
     //                 Collections.sort(sortedList);
     //                 if(!ans.contains(sortedList)){
     //                     ans.add(sortedList);
     //                 } 
     //             }
     //             set.add(nums[j]);
     //         }
     //         set.clear();
     //     }
     //     return ans;
     // }
 
     //two pointer
     public List<List<Integer>> threeSum(int[] nums) {
         int n = nums.length;
         Arrays.sort(nums);
         List<List<Integer>> ans = new ArrayList<>();
         for(int i =0 ; i < n ; i ++){
             if(i>0 && nums[i] == nums[i-1]){
                 continue;
             }
             int j = i+1;
             int k = n-1;
             while(j<k){
                 int sum = nums[i] + nums[j]+ nums[k];
                 if(sum < 0){
                     j++;
                 }
                 else if(sum > 0 ){
                     k--;
                 }else{
                     List<Integer> list = new ArrayList<>(Arrays.asList(nums[i] , nums[j] , nums[k]));
                     ans.add(list);
                     j++;
                     k--;
                     while(j < k && nums[j] == nums[j-1]){
                         j++;
                     }
                     while(j<k && nums[k] == nums[k+1]){
                         k--;
                     }
                 }
             }
         }
         return ans;
     }
 }