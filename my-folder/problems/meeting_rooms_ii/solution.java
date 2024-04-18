class Solution {
    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        PriorityQueue<Pair<Integer,Integer>> queue = new PriorityQueue<>((a,b) -> a.getValue() == b.getValue() ? Integer.compare(a.getKey(), b.getKey()) : Integer.compare(a.getValue(), b.getValue()));

        int max = 1;

        for(int i = 0 ; i < intervals.length ; i++){
            while(queue.size() > 0 && queue.peek().getValue() <= intervals[i][0]){
                queue.poll();
            }
            queue.add(new Pair<>(intervals[i][0], intervals[i][1]));
            max = Math.max(max, queue.size());
        }  

        return max;      
    }

}