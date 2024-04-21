class Solution {

    HashMap<Integer,Integer> map;
    public int numDecodings(String s) {

        map = new HashMap<>();

        HashSet<String> set = new HashSet<>();

        for(int i = 1 ; i <= 26 ; i++){
            set.add(String.valueOf(i));
        }

        return find(s, set, 0);
    }


    private int find(String s, HashSet<String> set, int curr){

        if(curr == s.length()){
            return 1;
        }

        if(map.containsKey(curr)){
            return map.get(curr);

        }
        int ans = 0;
        for(int i = curr + 1; i <= s.length() ; i++){

            if(set.contains(s.substring(curr, i)) && find(s, set, i) > 0){
                ans += find(s, set, i);
            }
        }
        map.put(curr,ans);
        return ans;

    }
}