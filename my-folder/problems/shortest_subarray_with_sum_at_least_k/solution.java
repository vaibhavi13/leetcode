class Solution {
    public int shortestSubarray(int[] nums, int k) {


        long[] prefixSum = new long[nums.length + 1];
        int minLen = nums.length + 1;

        for(int i = 0 ; i < nums.length ; i++){
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        Deque<Integer> queue = new ArrayDeque<>();

        for(int i = 0 ; i < nums.length + 1; i++){

           while(queue.size() > 0 && prefixSum[i] - prefixSum[queue.peek()] >= k){
            minLen = Math.min(minLen , i - queue.poll());
           }

           while(queue.size() > 0 && prefixSum[i] <= prefixSum[queue.peekLast()]){
             queue.pollLast();
           } 

            queue.add(i);
        }

        return minLen <= nums.length ? minLen : -1;
        
    }
}