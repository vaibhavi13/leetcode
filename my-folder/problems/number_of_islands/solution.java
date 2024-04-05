class Solution {
    public int numIslands(char[][] grid) {

        int count = 0;
        int visited[][] = new int[grid.length][grid[0].length];

        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[i].length ; j++){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                  count++;
                  dfs(grid,i,j, visited);
                }
            }
        }

        return count;
        
    }

    public void dfs(char[][] grid, int row , int col, int[][] visited){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || visited[row][col] == 1 || grid[row][col] == '0'){
            return;
        }

        visited[row][col] = 1;

        dfs(grid, row - 1, col, visited);
        dfs(grid, row + 1, col, visited);
        dfs(grid, row, col - 1, visited);
        dfs(grid, row, col + 1, visited);
    }
}