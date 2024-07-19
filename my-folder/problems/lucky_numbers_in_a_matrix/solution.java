class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {

        List<Integer> ans = new ArrayList<>();
    

        for(int i = 0 ; i < matrix.length ; i++){
            int minRow = -1;
            int min = Integer.MAX_VALUE;

            for(int j = 0 ; j < matrix[i].length ; j++){
                if( matrix[i][j] < min){
                    min = matrix[i][j];
                    minRow = j;
                }
            }

            int max = min;
            boolean isMax = true;
            for(int k = 0 ; k < matrix.length ; k++){
                if(matrix[k][minRow] > max && k != i){
                    isMax = false;
                    break;
                } 
            }

            if(isMax){
                ans.add(matrix[i][minRow]);
            }
        }

        return ans;
        
    }
}