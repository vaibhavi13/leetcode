class Solution {

    int directions[][] = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    int max_row;
    int max_col;


    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        max_row = heights.length;
        max_col = heights[0].length;
        boolean pacific[][] = new boolean[heights.length][heights[0].length];

        boolean atlantic[][] = new boolean[heights.length][heights[0].length];

        Queue<Pair<Integer,Integer>> queuePacific = new LinkedList<>();
        Queue<Pair<Integer,Integer>> queueAtlantic = new LinkedList<>();

        
        for(int i = 0 ; i < heights[0].length ; i++){
            queuePacific.add(new Pair<>(0,i));
            queueAtlantic.add(new Pair<>(heights.length - 1, i));
        }


        for(int i = 0 ; i < heights.length ; i++){
            queuePacific.add(new Pair<>(i,0));
            queueAtlantic.add(new Pair<>(i,heights[0].length - 1));
        }

        bfs(queuePacific,pacific,heights);
        bfs(queueAtlantic,atlantic,heights);

        List<List<Integer>> common = new ArrayList<>();

        for(int i = 0 ; i < heights.length ; i++){
            for(int j = 0 ; j < heights[i].length ; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    common.add(Arrays.asList(i,j));
                }
            }
        }

        return common;
       
    }

    private void bfs(Queue<Pair<Integer,Integer>> queue, boolean visited[][], int[][] heights){

        while(queue.size() > 0){
            Pair<Integer,Integer> pair = queue.poll();
            int row = pair.getKey();
            int col = pair.getValue();

            visited[row][col] = true;

            for(int d[] : directions){
                int new_row = row + d[0];
                int new_col = col + d[1];

                if(new_row >= 0 && new_row < max_row && new_col >= 0 && 
                    new_col < max_col && visited[new_row][new_col] == false &&
                    heights[new_row][new_col] >= heights[row][col]){
                    queue.add(new Pair<>(new_row, new_col));
                }
            }
        }

    }
}