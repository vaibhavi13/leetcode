class Solution {
    public int numPairsDivisibleBy60(int[] time) {

        int[] remainder = new int[60];
        int count = 0;
        
        for(int i = 0 ; i < time.length ; i++){
            if(time[i] % 60 == 0){
               count += remainder[time[i] % 60];
            }else{
                count += remainder[(60 - (time[i] % 60))];
            }
            remainder[time[i] % 60]++;
        }

        return count;
    }
}