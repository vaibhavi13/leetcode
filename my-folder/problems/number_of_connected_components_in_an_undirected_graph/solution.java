class Solution {

    public int countComponents(int n, int[][] edges) {

        HashMap<Integer,List<Integer>> adj = new HashMap<>();

        for(int i = 0 ; i < edges.length ; i++){
            adj.putIfAbsent(edges[i][0], new ArrayList<>());
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.putIfAbsent(edges[i][1], new ArrayList<>());
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int visited[] = new int[n];
        int count = 0;

        for(int i = 0 ; i < n ; i++){
            if(visited[i] != 1){
                count++;
                bfs(adj, i, visited);
            }
        }

        return count;
    }

    private void bfs(HashMap<Integer,List<Integer>> adj , int src, int visited[]){

        Queue<Integer> queue = new LinkedList<>();

        queue.add(src);
        visited[src] = 1;

        while(queue.size() > 0){

            Integer curr = queue.poll();

            List<Integer> neigh = adj.getOrDefault(curr, new ArrayList<>());

            for(Integer n : neigh){
                if(visited[n] == 0){
                    visited[n] = 1;
                    queue.add(n);
                }
            }
        }

    }
}