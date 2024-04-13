class Solution {
    public double knightProbability(int n, int k, int row, int column) {

        double dp[][][] = new double[k+1][n+1][n+1];
        dp[0][row][column] = 1;

        int directions[][] = {{-2,1}, {-1,2}, {1,2}, {2,1}, {2,-1}, {1,-2}, {-1,-2}, {-2,-1}};


        for(int i = 1 ; i <= k ; i++){
            for(int j = 0 ; j < n ; j++){
               for(int m = 0 ; m < n ; m++){
                  for(int d[] : directions){
                      int prev_row = j - d[0];
                      int prev_col = m - d[1];

                      if(prev_row >= 0 && prev_row < n && prev_col >= 0 && prev_col < n){
                         dp[i][j][m] += dp[i-1][prev_row][prev_col]/8.0;
                      }
                  }
               }
            }
        }

        double prob =0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                prob += dp[k][i][j];
            }
        }

        return prob;





    }
}