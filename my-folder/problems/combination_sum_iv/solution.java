class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();
    public int combinationSum4(int[] nums, int target) {

        return find(nums,target);
        
    }

    private int find(int[] nums, int target){

        if(target == 0){
            return 1;
        }

        if(map.containsKey(target)){
            return map.get(target);
        }

        int result = 0;

        for(int n : nums){

            if(n <= target){
                result += find(nums, target - n);
            }
        }
        map.put(target, result);
        return result;
    }
}