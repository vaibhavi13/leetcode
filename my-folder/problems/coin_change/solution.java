class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int dp[][] = new int[coins.length + 1 ][amount + 1];

        for(int i = 0 ; i < dp.length ; i++){
            for(int j = 0 ; j < dp[i].length ; j++){
                if(i == 0){
                    dp[i][j] = Integer.MAX_VALUE - 1;
                }

                if(i == 1){
                    if(j % coins[i-1] == 0){
                        dp[i][j] = j/coins[i-1];
                    }else{
                        dp[i][j] = Integer.MAX_VALUE - 1;
                    } 
                }
            }
        }

        for(int i = 2 ; i < dp.length ; i++){
            for(int j = 1; j < dp[i].length ; j++){
                if(coins[i-1] <= j){
                    dp[i][j] = Math.min(1 + dp[i][j-coins[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[coins.length][amount] == Integer.MAX_VALUE - 1 ? -1 : dp[coins.length][amount];


    }
}