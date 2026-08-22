class Solution {
    int n;
    int[][] dp;
    public int change(int amount, int[] coins) {
        n=coins.length;
        dp = new int[n+1][amount+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0, amount, coins);
    }

    public int solve(int i ,int amount,int[] coins) {
        if(i==n || amount<0){
            return 0;
        }

        if(amount==0){
            return 1;
        }

        if(dp[i][amount]!=-1){
            return dp[i][amount];
        }

        int take = solve(i,amount-coins[i], coins);
        int skip = solve(i+1, amount,coins);


        return dp[i][amount] = take+skip;
    }
}
