class Solution {
    public int findTheWinner(int n, int k) {

        return find(n,k) + 1;
        
    }

    private int find(int n, int k){
        if(n == 1){
            return 0 ;
        }
        return (find(n-1,k) + k) % n;
    }
}