class Solution {
    public int longestPalindrome(String s) {

        int lower[] = new int[26];
        int higher[] = new int[26];

        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);

            if(c >= 'a' && c <= 'z'){
               lower[c - 'a']++;
            }else{
                higher[c-'A']++;
            }
        }

        int count = 0 ;
        boolean oneFlag = false;
        
        for(int i = 0 ; i < 26 ; i++){
            if(lower[i] != 0){
                if(lower[i] % 2 == 0){
                    count += lower[i];
                }else{
                    count += ((lower[i]/2) * 2);
                    oneFlag = true;
                }
            }
            if(higher[i] != 0){
                if(higher[i] % 2 == 0){
                    count += higher[i];
                }else{
                    count += ((higher[i]/2) * 2);
                    oneFlag = true;
                }
            }
        }

        return oneFlag == true ? count + 1 : count;


        
    }
}