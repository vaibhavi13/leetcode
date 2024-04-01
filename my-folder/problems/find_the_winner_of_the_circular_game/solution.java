class Solution {
    public int findTheWinner(int n, int k) {

        //return find(n, k) + 1;

        int winner = 0;

        for(int i = 2; i <= n ; i++){
            winner = (winner + k) % i;
        }

        return winner + 1;
    }

    private int find(int n , int k){
        if(n == 1){
            return 0;
        }

        return (find(n-1, k) + k) % n;
    }
}