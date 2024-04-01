class Solution {
    int dp[][];
    public int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        for(int d[] : dp){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        return bfs(grid, 0, 0);
    }

    private int bfs(int[][] grid, int row, int col){
        if(row >= grid.length || col >= grid[row].length){
            return Integer.MAX_VALUE;
        }

        if(row == grid.length - 1 && col == grid[row].length - 1){
            return grid[row][col];
        }

        if(dp[row][col] != Integer.MAX_VALUE){
            return dp[row][col];
        }

        int right = bfs(grid, row, col + 1); 
        int down = bfs(grid, row + 1, col);

        return dp[row][col] = grid[row][col] + Math.min(down, right);
    }
}