class Solution {
    public int hardestWorker(int n, int[][] logs) {

        int max = logs[0][1];
        int res = logs[0][0];

        for(int i = 1 ; i < logs.length ;i++){

            int curr = logs[i][1] - logs[i-1][1];

            if(curr > max){
                max = curr;
                res = logs[i][0];
            }else if(curr == max && logs[i][0] < res){
                res = logs[i][0];
            }
        }

        return res;
        
    }
}