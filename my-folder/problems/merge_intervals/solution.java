class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        Deque<Pair<Integer,Integer>> queue = new ArrayDeque<>();

        for(int i = 0 ; i < intervals.length ; i++){
           int start = intervals[i][0];
           int end = intervals[i][1]; 
           if(queue.size() > 0 && queue.peekLast().getValue() >= intervals[i][0]){
                Pair<Integer,Integer> lastEle = queue.pollLast();
                start = Math.min(intervals[i][0], lastEle.getKey());
                end = Math.max(intervals[i][1], lastEle.getValue());
           }
           queue.add(new Pair<>(start, end));  
        }

        int ans[][] = new int[queue.size()][2];
        int c = 0;

        while(queue.size() > 0){
            ans[c][0] = queue.peek().getKey();
            ans[c][1] = queue.peek().getValue();
            c++;
            queue.poll();
        }

        return ans;

    }
}