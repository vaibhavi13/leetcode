class Solution {
    public int[][] highFive(int[][] items) {

        HashMap<Integer,PriorityQueue<Integer>> map = new HashMap<>();

        for(int item[] : items){
           map.putIfAbsent(item[0], new PriorityQueue<Integer>());
           PriorityQueue<Integer> pq = map.get(item[0]);
           pq.add(item[1]);
           if(pq.size() > 5){
            pq.poll();
           }
        }

        int[][] result = new int[map.size()][2];
        int c = 0;

        for(Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()){
            result[c][0] = entry.getKey();
            
            int sum = 0;
            PriorityQueue<Integer> temp = entry.getValue();
            while(temp.size() > 0){
                sum += temp.poll();
            }

            result[c][1] = sum/5;
            c++;
        }

        Arrays.sort(result, (a,b) -> Integer.compare(a[0], b[0]) );

        return result;
    }
}