class Solution {
    public int appendCharacters(String s, String t) {
           

        int p = 0 ;

        for(int i = 0 ; i < s.length() ; i++){
            if(t.charAt(p) == s.charAt(i)){
                p++;
            }
            if(p == t.length()){
                return 0;
            }
        }

        return t.length() - p;
        
    }
}