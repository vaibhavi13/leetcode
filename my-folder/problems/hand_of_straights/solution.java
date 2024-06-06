class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if(hand.length % groupSize != 0){
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i = 0 ; i < hand.length ; i++){
            map.put(hand[i], map.getOrDefault(hand[i],0) + 1);
        }

        while(map.size() > 0){

           int start = map.firstEntry().getKey();

           for(int i = start ; i < start + groupSize ; i++){
              if(!map.containsKey(i)){
                  return false;
              }
              map.put(i , map.get(i) - 1);

              if(map.get(i) == 0){
                 map.remove(i);
              }
           } 
        }

        return true;
        
    }
}