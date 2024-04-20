class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        dfs(image, sr, sc, image[sr][sc], color);

        return image;
        
    }

    private void dfs(int[][] image, int row , int col , int oldColor, int newColor){
        if(row < 0 || row >= image.length || col < 0 || col >= image[row].length || image[row][col] != oldColor || image[row][col] == newColor){
            return;
        }

        if(image[row][col] == oldColor){
            image[row][col] = newColor;
        }

        dfs(image,row - 1, col, oldColor, newColor);
        dfs(image,row + 1 ,col, oldColor,  newColor);
        dfs(image,row ,col - 1, oldColor, newColor);
        dfs(image,row, col + 1, oldColor, newColor);

    }
}