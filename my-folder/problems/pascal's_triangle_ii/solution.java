class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Arrays.asList(1));
        if(rowIndex == 0){
            ans.get(0);
        }
        ans.add(Arrays.asList(1,1));
        if(rowIndex == 1){
            ans.get(1);
        }

        for(int i = 2 ; i <= rowIndex ; i++){
            List<Integer> prev = ans.get(i-1);
            List<Integer> temp = new ArrayList<>();
            temp.add(1);

            for(int j = 0 ; j < prev.size() - 1 ; j++){
                temp.add(prev.get(j) + prev.get(j+1));
            }
            temp.add(1);
            ans.add(temp);
        }

        return ans.get(rowIndex);

    }
}