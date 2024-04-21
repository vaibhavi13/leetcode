class Solution {

    int mem[];
    public int rob(int[] nums) {

        if(nums.length == 0){
            return 0;
        }

        mem = new int[nums.length];
        Arrays.fill(mem, -1);

        if(nums.length == 1){
            return nums[0];
        }

        int first = find(nums,0 , nums.length - 2);
        Arrays.fill(mem, -1);
        int second = find(nums, 1 , nums.length - 1);

        return Math.max(first, second);
        
    }

    private int find(int nums[], int curr, int limit){

        if(curr > limit){
            return 0;
        }

        if(mem[curr] != -1){
            return mem[curr];
        }

        return mem[curr] = Math.max(nums[curr] + find(nums, curr + 2, limit), find(nums, curr + 1, limit));
        
         
    }
}