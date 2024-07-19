class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length()){
            return false;
        }

        int c[] = new int[26];

        for(int i = 0 ; i < s1.length() ; i++){
            c[s1.charAt(i) - 'a']++;
        }

        for(int i = 0 ; i + s1.length() <= s2.length(); i++){
            if(present(s2.substring(i , i + s1.length()), c)){
                return true;
            }
        }

        return false;
        
    }

    private boolean present(String s, int[] c){

        int c1[] = new int[26];

        for(int i = 0 ; i < s.length() ; i++){
            c1[s.charAt(i) - 'a']++;
        }

        for(int i = 0 ; i < 26 ; i++){
            if(c[i] != c1[i]){
                return false;
            }
        }

        return true;
    }
}