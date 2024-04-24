class Solution {
    HashMap<Integer,Integer> map;
    public int tribonacci(int n) {

        map = new HashMap<>();
        return find(n);
    }

    private int find(int n){

         if(n == 0){
            return 0;
        }

        if(n == 1){
            return 1;
        }

        if(n == 2){
            return 1;
        }

        if(map.containsKey(n)){
            return map.get(n);
        }

        int ans = find(n-3) + find(n-2) + find(n-1);
        map.put(n, ans);
        return ans;
    }
}