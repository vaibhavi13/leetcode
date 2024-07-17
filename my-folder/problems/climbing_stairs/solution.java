class Solution {
    int dp[];
    public int climbStairs(int n) {
        dp = new int[n+ 1];

        Arrays.fill(dp , -1);

        return find(1, n) + find(2, n);
        
    }

    private int find(int curr, int n){
        if(curr == n){
            return 1;
        }

        if(curr > n){
            return 0;
        }

        if(dp[curr] != -1){
            return dp[curr];
        }

        return dp[curr] = find(curr + 1 , n) + find(curr + 2 , n);
    }
}