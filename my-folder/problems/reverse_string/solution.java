class Solution {
    public void reverseString(char[] s) {
       char c;
       for(int i = 0 , j = s.length - 1 ; i < s.length/2 && j >= s.length/2 ; i++, j--){
            c = s[i];
            s[i] = s[j];
            s[j] = c;
       }


    }
}