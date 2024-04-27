class Solution {
    public long numberOfRightTriangles(int[][] grid) {
        
        int[][] upper = new int[grid.length][grid[0].length];
        
        for(int i = 1 ; i < upper.length ; i++){
            for(int j = 0 ; j < upper[i].length ; j++){
                upper[i][j] = grid[i-1][j] + upper[i-1][j];
            }
        }
        
        int[][] lower = new int[grid.length][grid[0].length];
        
        for(int i = grid.length - 2 ; i >=0 ; i--){
            for(int j = 0 ; j < grid[i].length ; j++){
                lower[i][j] = grid[i+1][j] + lower[i + 1][j];
            }
        }
        
        int[][] left = new int[grid.length][grid[0].length];
        
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 1; j < grid[i].length ; j++){
                left[i][j] = grid[i][j-1] + left[i][j-1];
            }
        }
        
        int[][] right = new int[grid.length][grid[0].length];
        
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = grid[i].length - 2 ; j >=0 ; j--){
                right[i][j] = grid[i][j+1] + right[i][j+1];
            }
        }
        
        long count = 0;
        
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[i].length ; j++){
                
                if(grid[i][j] == 1){
                    count += (upper[i][j] * left[i][j]) + (upper[i][j] * right[i][j]) + (lower[i][j] * left[i][j]) + (lower[i][j] * right[i][j]);
                   
                }
                
                
                
            }
        }
        
        return count;
        
    }
}