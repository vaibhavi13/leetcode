class Solution {
    public int[] sortByBits(int[] arr) {
        

        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() == b.getValue() 
                                                                               ? Integer.compare(a.getKey(), b.getKey()) 
                                                                               : Integer.compare(a.getValue(), b.getValue()));

        for(int i = 0 ; i < arr.length ; i++){
            pq.add(new Pair<>(arr[i], getCount(arr[i])));
        }

        int ans[] = new int[arr.length];

        int c = 0;

        while(pq.size() > 0){
            ans[c++] = pq.poll().getKey();
        }
        
        return ans;
    }

    private int getCount(int n){
        int count = 0;

        while(n != 0){
            n = n & n -1;
            count++;
        }
        return count;
    }
}