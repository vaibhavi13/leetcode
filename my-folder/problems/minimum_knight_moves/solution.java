class Solution {
    public int minKnightMoves(int x, int y) {

        int directions[][] = {{-2,1}, {-1,2}, {2,1}, {1,2}, {-2,-1}, {-1,-2}, {1,-2}, {2,-1}};
        int visited[][] = new int[603][603];
        int moves = 0;

        if(x == 0 && y == 0){
            return moves;
        }

        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();

        queue.add(new Pair<>(0,0));
        visited[300][300] = 1;
 
        while(queue.size() > 0){

            int curr_size = queue.size();

            moves++;

            for(int i = 0 ; i < curr_size ; i++){
                Pair<Integer,Integer> pair = queue.poll();
                
                int curr_row = pair.getKey();
                int curr_col = pair.getValue();

                for(int d[] : directions){
                    int new_row = curr_row + d[0];
                    int new_col = curr_col + d[1];
                    
                    if(new_row == x && new_col == y){
                        return moves;
                    }
                    if(visited[new_row + 300][new_col + 300] == 0){
                        queue.add(new Pair<>(new_row,new_col));
                        visited[new_row+300][new_col+300] = 1;
                    }
                }          
            }
      
        }

        return -1;
        
    }
}