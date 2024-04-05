class Solution {
    HashSet<Integer> visited;
    public boolean canReach(int[] arr, int start) {
        visited = new HashSet<>();
        return find(arr,start);    
    }

    private boolean find(int[] arr, int start){
        if(start < 0 || start >= arr.length || visited.contains(start)){
            return false;
        }
        
        visited.add(start);

        if(arr[start] == 0){
            return true;
        }

        return find(arr,start - arr[start]) || find(arr, start + arr[start]);
    }
}