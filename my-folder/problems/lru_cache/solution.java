class LRUCache {

    int maxCapacity;
    LinkedHashMap<Integer,Integer> cache;

    public LRUCache(int capacity) {
        maxCapacity = capacity;
        cache = new LinkedHashMap<>();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
           return -1;
        }
        int value = cache.get(key);
        cache.remove(key);
        cache.put(key,value);
        return value;
    }
    
    public void put(int key, int value) {

        if(cache.containsKey(key)){
           cache.remove(key);
        }
        cache.put(key,value);
        if(cache.size() > maxCapacity){
            int keyToBeDeleted = cache.keySet().iterator().next();
            cache.remove(keyToBeDeleted);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */