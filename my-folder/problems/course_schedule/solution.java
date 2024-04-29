class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer,List<Integer>> preq = new HashMap<>();
        int[] indegree = new int[numCourses];

        for(int i  = 0 ; i < prerequisites.length ; i++){
            for(int j = 0 ; j < prerequisites[i].length ; j++){
                preq.putIfAbsent(prerequisites[i][1], new ArrayList<>());
                preq.get(prerequisites[i][1]).add(prerequisites[i][0]);
                indegree[prerequisites[i][0]]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0 ; i < indegree.length ; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        while(preq.size() > 0){
            if(queue.size() == 0){
                return false;
            }

            int curr = queue.poll();

            for(int neigh : preq.getOrDefault(curr, new ArrayList<>())){
                indegree[neigh]--;
                if(indegree[neigh] == 0){
                    queue.add(neigh);
                }
            }

            preq.remove(curr);
        }

        return true;
        
    }
}