class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    public int rob(int[] nums) {
        
        if(nums.length == 1){
            return nums[0];
        }
        
        return Math.max(find(nums,0),find(nums,1));
    }

    private int find(int[] nums, int index){
        if(index >= nums.length){
            return 0;
        }

        if(map.containsKey(index)){
            return map.get(index);
        }

        int ans = Math.max(nums[index] + find(nums, index + 2), find(nums, index + 1));
        map.put(index, ans);
        return ans;
    }
}