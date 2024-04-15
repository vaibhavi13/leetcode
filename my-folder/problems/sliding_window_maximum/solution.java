class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> queue = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        for(int i = 0 ; i < k ; i++){

            while(queue.size() > 0 && nums[i] >= nums[queue.peekLast()]){
                queue.pollLast();
            }
            queue.add(i);
        }

        res.add(nums[queue.peek()]);

        for(int i = k ; i < nums.length ; i++){
           
           while(queue.size() > 0 && queue.peek() <= i - k){
                queue.poll();
           }

           while(queue.size() > 0 && nums[i] > nums[queue.peekLast()]){
                queue.pollLast();
            }
            queue.add(i); 
            res.add(nums[queue.peek()]);
        }




        return res.stream().mapToInt(i->i).toArray();
    }
}