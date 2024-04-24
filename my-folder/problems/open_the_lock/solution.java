class Solution {
    public int openLock(String[] deadends, String target) {

        HashMap<Character, Character> next = new HashMap<>();
        next.put('0', '1');
        next.put('1', '2');
        next.put('2', '3');
        next.put('3', '4');
        next.put('4','5');
        next.put('5', '6');
        next.put('6','7');
        next.put('7','8');
        next.put('8','9');
        next.put('9','0');

        HashMap<Character, Character> prev = new HashMap<>();
        prev.put('0','9');
        prev.put('1','0');
        prev.put('2','1');
        prev.put('3','2');
        prev.put('4','3');
        prev.put('5','4');
        prev.put('6','5');
        prev.put('7','6');
        prev.put('8','7');
        prev.put('9','8');

        HashSet<String> visited = new HashSet<>();

        visited.addAll(Arrays.asList(deadends));

        if(visited.contains(target)){
            return -1;
        }

        if(visited.contains("0000")){
            return -1;
        }

        Queue<String> pending = new LinkedList<>();
        pending.add("0000");
        visited.add("0000");

        int turn = 0;

        while(pending.size() > 0){

            int currSize = pending.size();

            for(int j = 0 ; j < currSize ; j++){
                
                String curr = pending.poll();

                if(curr.equals(target)){
                    return turn;
                }

                for(int i = 0 ; i < curr.length() ; i++){
                    StringBuilder sb = new StringBuilder(curr);
                    sb.setCharAt(i, next.get(sb.charAt(i)));
                    
                    if(!visited.contains(sb.toString())){
                        visited.add(sb.toString());
                        pending.add(sb.toString());
                    }

                    sb = new StringBuilder(curr);
                    sb.setCharAt(i, prev.get(sb.charAt(i)));

                    if(!visited.contains(sb.toString())){
                        visited.add(sb.toString());
                        pending.add(sb.toString());
                    }          
                }
            }

            turn++;

        }

        return -1;   
    }
}