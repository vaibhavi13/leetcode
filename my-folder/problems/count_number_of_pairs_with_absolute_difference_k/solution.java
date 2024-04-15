class Solution {
    public int countKDifference(int[] nums, int k) {

        int count = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n, map.getOrDefault(n,0) + 1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(map.containsKey(entry.getKey() + k)){
                count += map.get(entry.getKey() + k) * map.get(entry.getKey());
            }
        }

        return count;
        
    }
}