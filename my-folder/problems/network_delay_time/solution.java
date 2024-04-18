class Node{

    int v;
    int distance;

    Node(int v, int distance){
        this.v = v;
        this.distance = distance;
    }
}


class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        HashMap<Integer,List<Node>> adj = new HashMap<>();

        for(int t[] : times){
            adj.putIfAbsent(t[0], new ArrayList<>());
            adj.get(t[0]).add(new Node(t[1], t[2]));
        }

        HashMap<Integer,Node> distMap = new HashMap<>();

        PriorityQueue<Node> queue = new PriorityQueue<>((a,b) -> Integer.compare(a.distance, b.distance));
        Node src = new Node(k,0);
        distMap.put(k,src);
        queue.add(src);
        int visited[] = new int[n + 1];

        while(queue.size() > 0){
            Node curr = queue.poll();
            visited[curr.v] = 1;

            for(Node neigh : adj.getOrDefault(curr.v, new ArrayList<>())){
                if(visited[neigh.v] != 1){
                    if(distMap.containsKey(neigh.v)){
                                    if(curr.distance + neigh.distance < distMap.get(neigh.v).distance){
                                        distMap.put(neigh.v, new Node(curr.v, curr.distance + neigh.distance));
                                    }
                                    }else{
                                        distMap.put(neigh.v, new Node(curr.v, curr.distance + neigh.distance));
                                    }
                                        queue.add(new Node(neigh.v, curr.distance + neigh.distance));
                }
            }
        }

        int max = 0;

        for(int i = 1 ; i <= n ; i++){
            if(!distMap.containsKey(i)){
                return -1;
            }
            max = Math.max(max, distMap.get(i).distance);
        }



        return max;
    }
}