class Solution {
    int dest_row;
    int dest_col;
    int mem[][];
    public int uniquePaths(int m, int n) {

        mem = new int[m][n];
        for(int me[] : mem){
            Arrays.fill(me, -1);
        }

        dest_row = m -1;
        dest_col = n - 1;

        return dfs(0,0);         
    }

    private int dfs(int row, int col){
        
        if(row > dest_row || col > dest_col){
            return 0;
        }

        if(row == dest_row && col == dest_col){
            return 1;
        }

        if(mem[row][col] != -1){
            return mem[row][col];
        }

        return mem[row][col] = dfs(row+1,col) + dfs(row, col + 1);
    }
}