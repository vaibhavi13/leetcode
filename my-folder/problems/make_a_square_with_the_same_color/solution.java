class Solution {
    public boolean canMakeSquare(char[][] grid) {
        
        for(int i = 0 ; i <= 1 ; i++){
            for(int j = 0 ; j <= 1; j++){
                    
                    int black = 0 ;
                    int white = 0;
                    
                    for(int row = i ; row <= i + 1 ; row++){
                        for(int col = j ; col <= j + 1 ; col++){
                            if(grid[row][col] == 'B'){
                                black++;
                            }else{
                                white++;
                            }
                            
                        }
                    }
                    
                    if(black == 3 && white == 1 || black == 1 && white == 3 || black == 4 || white == 4){
                        return true;
                    }
                    
            }
        }
        
        return false;
        
    }
}