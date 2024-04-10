class Solution {
    public boolean exist(char[][] board, String word) {

        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[i].length ; j++){
                int visited[][] = new int[board.length][board[i].length];
                if(find(board,word,i,j, 0, visited)){
                    return true;
                }
            }
        }
        return false;      
    }

    private boolean find(char[][] board, String word, int row , int col, int index, int visited[][]){

        if(index >= word.length()){
            return true;
        }

        if(row < 0 || row >= board.length || col < 0 || col >= board[row].length || visited[row][col] == 1 || board[row][col] != word.charAt(index)){
            return false;
        }

        visited[row][col] = 1;

        boolean down = find(board,word,row + 1, col, index + 1, visited);
        boolean up = find(board,word, row - 1, col, index + 1, visited);
        boolean left = find(board,word,row, col - 1, index + 1, visited);
        boolean right = find(board, word, row, col + 1, index + 1, visited);

        visited[row][col] = 0;

        return down || up || left || right;     
    }
}