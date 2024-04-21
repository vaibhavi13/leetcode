class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0 ; i < nums.length ; i++){

            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int curr = nums[i];

            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){
                int sum = curr + nums[left] + nums[right];

                if(sum == 0){
                    ans.add(Arrays.asList(curr, nums[left], nums[right]));
                    left++;
                    
                    while(left < right && nums[left] == nums[left-1]){
                        left++;
                    }
                }else if(sum > 0){
                    right--;
                }else{
                    left++;
                }
            }

        }

        return ans;
        
    }
}