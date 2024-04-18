class Solution {
    public int findDuplicate(int[] nums) {

        int low = 1;
        int high = nums.length - 1;

        int duplicate = -1;

        while(low <= high){
            int count = 0;

            int mid = low + (high-low)/2;

            for(int n : nums){
                if(n <= mid){
                    count++;
                }
            }

            if(count > mid){
                duplicate = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
            
        }

        return duplicate;
        
    }
}