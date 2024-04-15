class Solution {
    public double knightProbability(int n, int k, int row, int column) {

        double dp[][][] = new double[k + 1][n + 1][n + 1];

        dp[0][row][column] = 1;

        int directions[][] = {{-2,1}, {-1,2}, {1,2}, {2,1}, {2,-1}, {1,-2}, {-1,-2}, {-2,-1}};

        for(int m = 1 ; m <= k ; m++){
            for(int i = 0; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    for(int d[] : directions){
                        int prev_i = i - d[0];
                        int prev_j = j - d[1];
                        if(prev_i >= 0 && prev_i < n && prev_j >=0 && prev_j < n){
                            dp[m][i][j] += dp[m-1][prev_i][prev_j]/8.0;
                        }
                    }
                }
            }
        }
        
        double prob = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                prob += dp[k][i][j];
            }
        }

        return prob;
        
    }
}