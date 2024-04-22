class Player{

    int score;
    int age;

    Player(int score, int age){
        this.score = score;
        this.age = age;
    }
}

class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {

        Player players[] = new Player[scores.length];

        for(int i = 0 ; i < scores.length ; i++){
            Player ply = new Player(scores[i], ages[i]);
            players[i] = ply;
        }

        Arrays.sort(players, (a,b) -> a.age == b.age ? Integer.compare(a.score, b.score) : Integer.compare(a.age,b.age));

        int max = 0;

        int dp[] = new int[scores.length];

        for(int i = 0 ; i < scores.length ; i++){
            dp[i] = players[i].score;
            max = Math.max(max, dp[i]);
        }

        for(int i = 0 ; i < scores.length ; i++){
            for(int j = i - 1 ; j >=0 ; j--){
                if(players[i].score >= players[j].score){
                    dp[i] = Math.max(dp[i], players[i].score + dp[j]);
                }
            }

            max = Math.max(max, dp[i]);
        }



        return max;



        
        
    }
}