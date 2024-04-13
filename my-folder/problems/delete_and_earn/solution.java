class Solution {

    HashMap<Integer,Integer> points = new HashMap<>();
    HashMap<Integer,Integer> cache = new HashMap<>();

    public int deleteAndEarn(int[] nums) {
        int max = 0;
        
        for(int n : nums){
            points.put(n, points.getOrDefault(n,0) + n);
            max = Math.max(max, n);
        }

        return find(max);         
    }

    private int find(int num){
        if(num == 0){
            return 0;
        }

        if(num == 1){
            return points.getOrDefault(1,0);
        }

        if(cache.containsKey(num)){
            return cache.get(num);
        }

        int ans = Math.max(find(num-1), find(num - 2) + points.getOrDefault(num,0));
        cache.put(num,ans);
        return ans;
    }
}