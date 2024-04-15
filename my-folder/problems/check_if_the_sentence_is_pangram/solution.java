class Solution {
    public boolean checkIfPangram(String sentence) {

        int c[] = new int[26];

        for(int i = 0 ; i < sentence.length() ; i++){
            c[sentence.charAt(i) - 'a']++;
        }

        for(int n : c){
            if(n  == 0){
                return false;
            }
        }

        return true;
        
    }
}