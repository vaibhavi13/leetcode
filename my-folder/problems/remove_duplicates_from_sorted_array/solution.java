class Solution {
    public int removeDuplicates(int[] nums) {
        // 1 1 2 3 4
        int count = 0 ;
        
        int i = 0 ; 
        
        while(i < nums.length){ // 0 < 5
            while(i < nums.length - 1 && nums[i] == nums[i+1]){
                i++; // i == 1
            }
            nums[count] = nums[i];
            count++;
            i++;
        }
        
        return count;
        
    }
}