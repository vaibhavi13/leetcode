class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        

        HashMap<Integer, Integer> count = new HashMap<>();

        for(int a : arr){
            count.put(a, count.getOrDefault(a, 0) + 1);
        }

        HashSet<Integer> visited = new HashSet<>();

        for(Map.Entry<Integer,Integer> entry : count.entrySet()){
            if(visited.contains(entry.getValue())){
                return false;
            }else{
                visited.add(entry.getValue());
            }

        }

        return true;
    }
}