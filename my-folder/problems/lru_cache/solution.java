class LRUCache {

    LinkedHashSet<Integer> set;
    int maxCapacity;
    HashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        set = new LinkedHashSet<>();
        map = new HashMap<>();
        maxCapacity = capacity;
    }
    
    public int get(int key) {

        if(!map.containsKey(key)){
            return -1;
        }

        set.remove(key);
        set.add(key);

        return map.get(key);        
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key)){
            set.remove(key);
        }

        map.put(key, value);
        set.add(key);

        if(set.size() > maxCapacity){
            Iterator itr = set.iterator();
            int keyToDelete = (int) itr.next();
            set.remove(keyToDelete);
            map.remove(keyToDelete);
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */