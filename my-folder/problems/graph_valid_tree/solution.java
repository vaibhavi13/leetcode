class Solution {
    public boolean validTree(int n, int[][] edges) {

        if(edges.length == 0){
            return n == 1;
        }

        HashMap<Integer,List<Integer>> adj = new HashMap<>();


        for(int i = 0 ; i < edges.length ; i++){
            adj.putIfAbsent(edges[i][0], new ArrayList<>());
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.putIfAbsent(edges[i][1], new ArrayList<>());
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int start = edges[0][0];
 

        boolean visited[] = new boolean[n];
        if(dfs(adj, visited, start, start)){
            return false;
        }

        int count = 0;

        for(boolean b : visited){
            if(b){
                count++;
            }
        }

        return count == n;
    }

    private boolean dfs(HashMap<Integer,List<Integer>> adj, boolean visited[], int node ,int parent){

        visited[node] = true;

        List<Integer> children = adj.get(node);

        for(Integer child : children){
            if(child != parent && visited[child]){
                return true;
            }
            if(!visited[child]){
              dfs(adj, visited, child, node);

            }
        }




        return false;

    }
}