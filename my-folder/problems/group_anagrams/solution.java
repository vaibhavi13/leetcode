class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> map = new HashMap<>();

        for(int i = 0 ; i < strs.length ; i++){

            int c[] = new int[26];

            for(int j = 0 ; j < strs[i].length() ; j++){
                c[strs[i].charAt(j) - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for(int ch : c){
                key.append(ch);
                key.append("#");
            }
            map.putIfAbsent(key.toString(), new ArrayList<>());
            map.get(key.toString()).add(strs[i]);
        }

        List<List<String>> ans = new ArrayList<>();

        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            ans.add(entry.getValue());
        }


        return ans;
    }
}