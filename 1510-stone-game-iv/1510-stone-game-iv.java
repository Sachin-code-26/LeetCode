class Solution {
    Boolean[] dp;
    public boolean winnerSquareGame(int n) {
        dp = new Boolean[n+1];
        
        return solve(n);
    }

    public boolean solve(int n){
        if(n==0){
            return dp[n]=false;
        }

        if(dp[n]!=null){
            return dp[n];
        }

        for(int k=1;k*k<=n;k++){

            if(solve(n-k*k)==false){ //bob's turn 
                return dp[n] =true;
            }
        }

        return dp[n]=false;
    }
}