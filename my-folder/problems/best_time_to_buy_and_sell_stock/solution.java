class Solution {
    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for(int i = 0 ; i < prices.length ; i++){
            minValue = Integer.min(minValue, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minValue);
        }
        
        return maxProfit;
        
    }
}