class Solution {
    public int countSubstrings(String s) {

        int count = 0;
        
        for(int i = 0 ; i < s.length() ; i++){
            count += find(s, i, i);
            count += find(s, i, i + 1);
        }

        return count;        
    }

    private int find(String s, int left, int right){
        int ans = 0;

        while(left >= 0 && right < s.length()){     
            if(s.charAt(left) != s.charAt(right)){
              break;
            }
            ans++;
            left--;
            right++;
        }

        return ans;
    }
}