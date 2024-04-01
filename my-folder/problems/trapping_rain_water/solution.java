class Solution {
    public int trap(int[] height) {

        int leftMax[] = new int[height.length];
        int rightMax[] = new int[height.length];

        int leftMaxVal = Integer.MIN_VALUE;
        int rightMaxVal = Integer.MIN_VALUE;

        for(int i = 0 ; i < leftMax.length ; i++){
            leftMaxVal = Math.max(leftMaxVal, height[i]);
            leftMax[i] = leftMaxVal;
        }

        for(int j = rightMax.length - 1; j >= 0 ; j--){
            rightMaxVal = Math.max(rightMaxVal, height[j]);
            rightMax[j] = rightMaxVal;
        }

        int dp[] = new int[height.length];

        for(int i = 0 ; i < height.length ; i++){
            dp[i] = Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        int sum = 0;

        for(int d : dp){
            sum += d;
        }

        return sum;
    }
}