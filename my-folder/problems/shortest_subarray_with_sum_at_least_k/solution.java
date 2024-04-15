class Solution {
    public int shortestSubarray(int[] nums, int k) {
        
        // 0 1 2 3 4 5
        // x y z a b c

        // b - x >= k
        // -> b should be greater than x 
        // b-x >=k -> delete x -> 

        // montonically increasing queue of prefixsum

        long prefixSum[] = new long[nums.length + 1];

        for(int i = 0 ; i < nums.length ; i++){
            prefixSum[i+1] = prefixSum[i] + nums[i];
        } 

        int minLen = nums.length + 1;

        Deque<Integer> queue = new ArrayDeque<>();

        for(int i = 0 ; i < nums.length + 1; i++){

            while(queue.size() > 0 && prefixSum[i] - prefixSum[queue.peek()] >= k){
                minLen = Math.min(minLen, i - queue.poll());
            }

            while(queue.size() > 0 && prefixSum[i] <= prefixSum[queue.peekLast()]){
                queue.pollLast();
            }

            queue.add(i);
        }





        return minLen <= nums.length ? minLen : -1;

        

    }
}