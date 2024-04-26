class Solution {
    public int longestIdealString(String s, int k) {
        

        int dp[] = new int[26];

        int res = 0;

        for(int i = 0 ; i < s.length() ; i++){
            int curr = s.charAt(i) - 'a';

            int best = 0;

            for(int prev = 0 ; prev < 26 ; prev++){
                if(Math.abs(curr - prev) <= k){
                    best = Math.max(best, dp[prev]);
                }
            }

            dp[curr] = Math.max(dp[curr], best + 1);
            res = Math.max(res, dp[curr]);
        }

        return res;


    }
}