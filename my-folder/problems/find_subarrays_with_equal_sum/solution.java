class Solution {
    public boolean findSubarrays(int[] nums) {

        HashSet<Integer> sum = new HashSet<>();

        for(int i = 0 ; i < nums.length - 1; i++){

            int curr = nums[i] + nums[i + 1];
            if(sum.contains(curr)){
                return true;
            }
            sum.add(curr);
        }

        return false;
        
    }
}