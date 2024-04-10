class RandomizedSet {

    List<Integer> list;
    HashMap<Integer,Integer> map;
    Random rand;


    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>(); 
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val,list.size());
        list.add(list.size(), val);
        return true;
    }
    
    public boolean remove(int val) {

        if(!map.containsKey(val)){
            return false;
        }  
        int pos = map.get(val);
        map.put(list.get(list.size()-1), pos);
        list.set(pos,list.get(list.size()-1));
        list.remove(list.size()-1);
        map.remove(val);
        return true;    
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */