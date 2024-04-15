class Solution {

    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        find(nums, new ArrayList<>());

        return ans;
    }

    private void find(int[] nums, List<Integer> list){

        if(list.size() == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0 ; i < list.size() ; i++){
                temp.add(nums[list.get(i)]);
            }
            ans.add(temp);
            return;
        }
        
        for(int i = 0 ; i < nums.length ; i++){
            if(!list.contains(i)){
                list.add(i);
                find(nums,list);
                list.remove(list.size() - 1);
            }
        }

    }
}