class Solution {
    int dp[];

    public int climbStairs(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp , -1);
        return find(n,1) + find(n, 2);
    }

    private int find(int n , int curr){
        if(curr > n){
            return 0;
        }
        if(curr == n){
            return 1;
        }
        
        if(dp[curr] != -1){
            return dp[curr];
        }

        return dp[curr] = find(n, curr + 1) + find(n, curr + 2);
    }
}