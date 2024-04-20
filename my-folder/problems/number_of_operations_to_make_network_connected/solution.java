class Solution {

    public int makeConnected(int n, int[][] connections) {

        if(connections.length < n - 1){
            return -1;
        }

        HashMap<Integer,List<Integer>> adj = new HashMap<>();

        for(int i = 0 ; i < connections.length ; i++){
            adj.putIfAbsent(connections[i][0], new ArrayList<>());
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.putIfAbsent(connections[i][1], new ArrayList<>());
            adj.get(connections[i][1]).add(connections[i][0]);
        }

        int numberOfComponents = 0 ;
        int visited[] = new int[n];

        for(int i = 0 ; i < n ; i++){
            if(visited[i] == 0){
                numberOfComponents++;
                bfs(adj, visited, i);
            }
        }

        return numberOfComponents - 1;
    }

    private void bfs(HashMap<Integer,List<Integer>> adj, int[] visited, int start){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;

        while(queue.size() > 0){

            int curr = queue.poll();

            for(Integer n : adj.getOrDefault(curr, new ArrayList<>())){

                if(visited[n] == 0){
                    visited[n] = 1;
                    queue.add(n);
                }

            }

        }



    }
}