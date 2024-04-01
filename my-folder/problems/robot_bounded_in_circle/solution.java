class Solution {
    public boolean isRobotBounded(String instructions) {
        
        int x = 0;
        int y = 0;

        char d = 'N';

        HashMap<String, Character> map = new HashMap<>();
        map.put("NL",'W');
        map.put("NR", 'E');
        map.put("WL", 'S');
        map.put("WR", 'N');
        map.put("SL", 'E');
        map.put("SR", 'W');
        map.put("EL", 'N');
        map.put("ER", 'S');

        for(int i = 0 ; i < instructions.length() ; i++){
           if(instructions.charAt(i) == 'G'){
              if(d == 'N'){
                y = y + 1;
              }else if(d == 'W'){
                x = x - 1; 
              }else if(d == 'S'){
                y = y - 1; 
              }else if(d == 'E'){
                x = x + 1;
              }
           }else if(instructions.charAt(i) == 'L'){
               d = map.get(String.valueOf(d)+"L");

           }else if(instructions.charAt(i) == 'R'){
             d= map.get(String.valueOf(d)+"R");
           }
        }

        if( (x == 0 && y == 0) || d != 'N'){
            return true;
        }

        return false;

    }
}