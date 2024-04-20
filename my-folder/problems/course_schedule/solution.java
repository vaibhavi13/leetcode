class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < numCourses ; i++){
           adj.add(new ArrayList<>());
        }

        int indegree[] = new int[numCourses];

        for(int i = 0 ; i < prerequisites.length ; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0 ; i < indegree.length ; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        
        int visited = 0;

        while(queue.size() > 0){

            int curr = queue.poll();
            visited++;

            for(Integer n : adj.get(curr)){
                indegree[n]--;
                if(indegree[n] == 0){
                    queue.add(n);
                }
            }

        }


        return visited == numCourses;

        
    }
}