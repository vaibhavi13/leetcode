class Solution {
    public int lengthOfLIS(int[] nums) {

        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i < nums.length ; i++){
            for(int j = i ; j >= 0 ; j--){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;   
    }
}