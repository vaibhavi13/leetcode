class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int start = weights[0]; // 1

        int sum = 0 ;

        for(int w : weights){
            sum += w; //8
        }

        int end = sum;
        int minWeight = sum;

        while(start <= end){
            int mid = (start + end)/2; // 4
            if(possible(weights, days, mid)){
                minWeight = Math.min(minWeight, mid);
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return minWeight;
    }

    private boolean possible(int[] weights, int days, int maxWeight){
        
        int countDays = 1;
        int sum = 0;

        for(int i = 0 ; i < weights.length ; i++){

            if(weights[i] > maxWeight){
                return false;
            }

            sum += weights[i];

            if(sum > maxWeight){
                countDays++;
                sum = weights[i];
            }

        }

        return countDays <= days;

    }
}