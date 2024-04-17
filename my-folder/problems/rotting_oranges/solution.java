class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();

        int freshOranges = 0;

        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[i].length ; j++){
                if(grid[i][j] == 1){
                    freshOranges++;
                }else if(grid[i][j] == 2){
                    queue.add(new Pair<>(i , j));
                }
            }
        }

        if(freshOranges == 0){
            return 0;
        }
        queue.add(new Pair<>(-1, -1));
        int mins = -1;

        int directions[][] = {{0,1}, {0 , -1}, {-1,0}, {1,0}};

        while(queue.size() > 0){

            List<Pair<Integer,Integer>> list = new ArrayList<>();

            while(queue.size() > 0){
                list.add(queue.poll());
            }

            for(Pair<Integer,Integer> pair : list){
                if(pair.getKey() == -1){
                    mins++;
                }else{
                    int curr_row = pair.getKey();
                    int curr_col = pair.getValue();

                    for(int d[] : directions){
                        int new_row = curr_row + d[0];
                        int new_col = curr_col + d[1];

                        if(new_row >= 0 && new_row < grid.length && new_col >= 0 && new_col < grid[grid.length-1].length && grid[new_row][new_col] == 1){
                            grid[new_row][new_col] = 2;
                            freshOranges--;
                            queue.add(new Pair<>(new_row,new_col));
                        }
                    }
                }
            }

            if(queue.size() > 0){
               queue.add(new Pair<>(-1,-1));
            }

        }

        return freshOranges > 0 ? - 1 : mins;
    }
}