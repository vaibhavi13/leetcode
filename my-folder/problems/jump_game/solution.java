class Solution {

    boolean reached = false;
    HashMap<Integer, Boolean> map;
    public boolean canJump(int[] nums) {

        map = new HashMap<>();
        
        for(int i = nums[0] ; i >= 0 ; i--){
            check(nums, i);
        }

        return reached;
    
    }

    private boolean check(int[] nums, int curr){

        if(curr >= nums.length || reached == true){
            return false;
        }

        if(curr == nums.length - 1){
            reached = true;
            return true;
        }

        if(map.containsKey(curr)){
            return map.get(curr);
        }

        boolean possible = false;

        for(int i = nums[curr] ; i >= 1 ; i--){
            possible = possible || check(nums, curr + i);
        }

        map.put(curr, possible);

        return possible;
    }
}