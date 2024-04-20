class Solution {

    int dp[];
    public int rob(int[] nums) {
        dp = new int[nums.length + 1];
        Arrays.fill(dp, - 1);

        return Math.max(find(nums,0),find(nums,1)); 
    }

    private int find(int[] nums, int curr){
        if(curr >= nums.length){
            return 0;
        }

        if(dp[curr] != -1){
            return dp[curr];
        }

        return dp[curr] = Math.max(nums[curr] + find(nums, curr + 2), find(nums,curr+1));
    }
}