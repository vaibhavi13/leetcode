class Solution {
    public int maxProfit(int[] prices) {

      int values[] = new int[prices.length];

      for(int i = 1; i < prices.length ; i++){
          values[i] = prices[i] - prices[i-1];
      }

      int sum = 0 ;

      for(int i = 0 ; i < values.length ; i++){
        if(values[i] > 0){
            sum += values[i];
        }
      }

      return sum;


    }
}