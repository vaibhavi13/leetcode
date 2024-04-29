class Node{

    int v;
    int distance;

    Node(int v , int distance){
        this.v = v;
        this.distance = distance;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {


        HashMap<Integer, List<Node>> adj = new HashMap<>();

        for(int i = 0 ; i < times.length ; i++){
            adj.putIfAbsent(times[i][0],new ArrayList<>());
            adj.get(times[i][0]).add(new Node(times[i][1],times[i][2]));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>((a,b) -> Integer.compare(a.distance, b.distance));
        HashMap<Integer,Node> distMap = new HashMap<>();
        Node src = new Node(k,0);
        queue.add(src);
        distMap.put(k,src);
        HashSet<Integer> visited = new HashSet<>();

        while(queue.size() > 0){
            Node curr = queue.poll();
            visited.add(curr.v);

            for(Node neigh : adj.getOrDefault(curr.v, new ArrayList<>())){
                
                if(!visited.contains(neigh.v)){
                    if(distMap.containsKey(neigh.v)){
                        if(curr.distance + neigh.distance < distMap.get(neigh.v).distance){
                            distMap.put(neigh.v, new Node( curr.v, neigh.distance + curr.distance));
                        }
                    }else{
                        distMap.put(neigh.v, new Node( curr.v, neigh.distance + curr.distance));
                    }
                    queue.add(new Node(neigh.v, curr.distance + neigh.distance));
                }
            }

        }

        int max = 0;

        for(int i = 1 ; i <=n ;i++){
            if(!distMap.containsKey(i)){
                return -1;
            }
            max = Math.max(max, distMap.get(i).distance);
        }
        
        return max;
    }
}