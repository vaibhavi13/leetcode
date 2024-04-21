class Solution {

    Boolean mem[];
    public boolean wordBreak(String s, List<String> wordDict) {

        mem = new Boolean[s.length()];

        return find(s, new HashSet<>(wordDict), 0);
        
    }

    private boolean find(String s, HashSet<String> wordDict, int start){

        if(s.length() == start){
            return true;
        }

        if(mem[start] != null){
            return mem[start];
        }

        for(int i = start + 1; i <= s.length() ; i++){
            if(wordDict.contains(s.substring(start, i)) && find(s,wordDict,i)){
                return mem[start] = true;
            }
        }

        return mem[start] = false;
    }
}