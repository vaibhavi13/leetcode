class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int answer = 0;

        int currGain = 0, totalGain = 0;

        for(int i = 0 ; i < gas.length ; i++){
            currGain += gas[i] - cost[i];

            totalGain += gas[i] - cost[i];

            if(currGain < 0){
                answer = i + 1;
                currGain = 0;
            }
        }

        return totalGain < 0 ? -1 : answer;
        
    }
}