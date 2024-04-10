class LFUCache {

    HashMap<Integer, Pair<Integer,Integer>> mainCache;
    HashMap<Integer, LinkedHashSet<Integer>> frequencyCache;
    int maxCapacity;
    int minFreq;
    public LFUCache(int capacity) {   
        mainCache = new HashMap<>();
        frequencyCache = new HashMap<>();
        maxCapacity = capacity;
        minFreq = 0;
    }
    
    public int get(int key) {

        if(!mainCache.containsKey(key)){
            return -1;
        }

        Pair<Integer,Integer> pair = mainCache.get(key);
        int freq = pair.getKey();
        int value = pair.getValue();
        LinkedHashSet<Integer> set = frequencyCache.get(freq);
        set.remove(key);
        if(set.size() == 0){
            frequencyCache.remove(freq);
            if(freq == minFreq){
                minFreq++;
            }
        }
        insert(key,freq + 1, value);
        return value;
    }

    private void insert(int key, int freq, int value){
        frequencyCache.putIfAbsent(freq, new LinkedHashSet<Integer>());
        frequencyCache.get(freq).add(key);
        mainCache.put(key, new Pair<Integer,Integer>(freq, value));
    }
    
    public void put(int key, int value) {

        if(maxCapacity <= 0){
            return;
        }

        Pair<Integer,Integer> pair = mainCache.get(key);

        if(pair != null){
           mainCache.put(key, new Pair<Integer,Integer>(pair.getKey(),value));
           get(key);
           return;
        }

        if(mainCache.size() == maxCapacity){
            LinkedHashSet<Integer> set = frequencyCache.get(minFreq);
            int keyToBeDeleted = set.iterator().next();
            set.remove(keyToBeDeleted);
            mainCache.remove(keyToBeDeleted);
            if(set.size() == 0){
                frequencyCache.remove(minFreq);
            }
        }

        minFreq = 1;
        insert(key, 1, value);

    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */