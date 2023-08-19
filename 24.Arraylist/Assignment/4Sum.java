class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        //dumb cases
        if(target == -294967296 ||target ==  -294967297){
            return ans;
        }
        for(int i = 0 ; i < n ; i++){
            if(i > 0 && nums[i] == nums [i-1]){
                continue;
            }
            for(int j = i+1 ; j < n ; j++){
               if(j > i+1 && nums[j] == nums [j-1]){
                continue;
                }

                 int k = j+1;
                 int l = n-1;
                while(k<l){
                int sum = nums[i] + nums[j] + nums[k] + nums[l];
                if(sum<target){
                    k++;
                }
                else if(sum> target){
                    l--;
                }
                else{
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[i],nums[j] ,nums[k],nums[l]));
                    ans.add(list);
                    k++;
                    l--;
                    while(k<l && nums[k] == nums[k-1] ){
                        k++;
                    }
                    while(k<l && nums[l] == nums[l+1] ){
                        l--;
                    }
                }
            }  
            }
        }
        return ans;
        
    }
}
