class Solution {
    public int makeConnected(int n, int[][] connections) {

        if(connections.length < n - 1){
            return -1;
        }

        int noOfComponents = 0;

        int[] visited = new int[n];

        HashMap<Integer,List<Integer>> adj = new HashMap<>();

        for(int i = 0 ; i < connections.length ; i++){
            adj.putIfAbsent(connections[i][0], new ArrayList<>());
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.putIfAbsent(connections[i][1], new ArrayList<>());
            adj.get(connections[i][1]).add(connections[i][0]);
        }

        for(int i = 0 ; i < n ; i++){
            if(visited[i] == 0){
                noOfComponents++;
                bfs(adj,i,visited);
            }
        }
        
        return noOfComponents - 1;
    
    }

    private void bfs(HashMap<Integer, List<Integer>> adj, int node, int[] visited){
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = 1;

        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int neigh : adj.getOrDefault(curr,new ArrayList<>())){
                if(visited[neigh] == 0){
                    queue.add(neigh);
                    visited[neigh] = 1;
                }
            }
        } 
    }


}