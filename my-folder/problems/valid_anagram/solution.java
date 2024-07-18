class Solution {
    public boolean isAnagram(String s, String t) {

        int c[] = new int[26];

        for(int i = 0 ; i < s.length() ; i++){
            c[s.charAt(i) - 'a']++;
        }

        for(int j = 0 ; j < t.length() ; j++){
            c[t.charAt(j) - 'a']--;
        }

        for(int i = 0 ; i < 26 ; i++){
            if(c[i] != 0){
                return false;
            }
        }

        return true;
        
    }
}