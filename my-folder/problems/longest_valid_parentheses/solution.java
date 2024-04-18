class Solution {
    public int longestValidParentheses(String s) {

        int max = 0;

        int l = 0 , r = 0;

        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);

            if( c == '('){
                l++;
            }else{
                r++;
            }
            if(l == r){
                max = Math.max(max, l + r);
            }else if(r > l){
                r = 0 ;
                l = 0;
            }
        }

        l = 0 ;
        r = 0;
        for(int i = s.length() - 1 ; i >= 0 ; i--){
            char c = s.charAt(i);

            if( c == '('){
                l++;
            }else{
                r++;
            }
            if(l == r){
                max = Math.max(max, l + r);
            }else if( l > r){
                r = 0 ;
                l = 0;
            }
        }
 
        return max;
        
    }
}