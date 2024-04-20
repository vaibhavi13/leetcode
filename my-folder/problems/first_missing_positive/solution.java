class Solution {
    public int firstMissingPositive(int[] nums) {

        int i = 0 ;

        while( i < nums.length){
            int j = nums[i] - 1;

            if( j >= 0 && j < nums.length && nums[i] != nums[j]){
                swap(nums, i , j);
            }else{
                i++;
            }
        }

        int c = 1;

        for(int m = 0; m < nums.length ; m++){
            if(nums[m] != c){
                return c;
            }
            c++;
        }

        return c;
        
    }

    private void swap(int[] nums, int a, int b){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}