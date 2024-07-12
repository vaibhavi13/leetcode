class Solution {
    public int maxProfit(int[] prices) {
        
        int profit = 0 ;
        int low = 0 ;
        
        for(int i = 0 ; i < prices.length - 1; i++){
            if(prices[i+1] < prices[i]){
                profit += prices[i] - prices[low];
                low = i + 1;
            }
        }
        
        profit += prices[prices.length - 1] - prices[low];
        
        return profit;
        
    }
}