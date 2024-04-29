class Trie {

    HashMap<Character, Trie> map;
    boolean endOfWord;

    public Trie() {
        map = new HashMap<>();
        endOfWord = false;
    }
    
    public void insert(String word) {

        Trie temp = this;
        for(int i = 0 ; i < word.length() ; i++){
            if(!temp.map.containsKey(word.charAt(i))){
                temp.map.put(word.charAt(i), new Trie());
            }
            temp = temp.map.get(word.charAt(i));
        }
        temp.endOfWord = true;
    }
    
    public boolean search(String word) {

        Trie temp = this;

        for(int i = 0 ; i < word.length() ; i++){
            if(!temp.map.containsKey(word.charAt(i))){
               return false; 
            }
            temp = temp.map.get(word.charAt(i));
        }
        
        return temp.endOfWord;
        
    }
    
    public boolean startsWith(String prefix) {

        Trie temp = this;

        for(int i = 0 ; i < prefix.length() ; i++){
            if(!temp.map.containsKey(prefix.charAt(i))){
               return false; 
            }
            temp = temp.map.get(prefix.charAt(i));
        }

        return true;

        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */