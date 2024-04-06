class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        if(m == 0){
            return false;
        }

        int left = 0 ;
        int right = m * n - 1;

        while(left <= right){
            int mid = (left + right)/2;
            int pivot = matrix[mid/n][mid % n];
            if(pivot == target){
              return true;
            }else if(pivot > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return false;
        
    }
}