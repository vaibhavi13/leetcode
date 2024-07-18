class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int size = Integer.MAX_VALUE;

        int start = 0 ;
        int end = 0 ;
        int sum = 0 ;

    

        while(start <= end && end < nums.length){
              sum += nums[end];

              while(sum >= target){
                 size = Math.min(size, end - start + 1);
                 sum -= nums[start];
                 start++;
              }
              end++;
        }

        return size == Integer.MAX_VALUE ? 0 : size;
        
    }
}