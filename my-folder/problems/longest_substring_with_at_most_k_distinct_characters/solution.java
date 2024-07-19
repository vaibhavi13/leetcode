class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        int start = 0 ;
        int end = 0 ;
        int maxLen = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        while(end < s.length()){
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end),0) + 1);

            while(map.size() > k){
            map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                if(map.get(s.charAt(start)) == 0){
                    map.remove(s.charAt(start));
                }
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }

        return maxLen;
        
    }
}