class Solution {
    public String[] findRelativeRanks(int[] score) {
        
        int temp[] = new int[score.length];
        
        for(int i = 0 ; i < score.length ; i++){
            temp[i] = score[i];
        }

        Arrays.sort(temp);
        
        int c = 1;

        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = temp.length - 1 ; i >=0 ; i--){
            map.put(temp[i], c++);
        }

        String ans[] = new String[score.length];

        for(int i = 0 ; i < score.length ; i++){
            if(map.get(score[i]) == 1){ 
                ans[i] = "Gold Medal";
            }else if(map.get(score[i]) == 2){
                ans[i] = "Silver Medal";
            }else if(map.get(score[i]) == 3){
                ans[i] = "Bronze Medal";
            }else{
                ans[i] = String.valueOf(map.get(score[i]));
            }
        }
        
        return ans;
    }
}