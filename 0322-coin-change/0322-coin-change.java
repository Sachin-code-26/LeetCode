class Solution {
    int n;
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        n = coins.length;
        dp = new int[n+1][amount+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int ans = solve(0, amount,coins);
        return ans==Integer.MAX_VALUE?-1:ans;
    }

    public int solve(int i, int remAmount , int[] coins){

        if(remAmount==0){
            return 0;
        }

        if(i>=n || remAmount<0){
            return Integer.MAX_VALUE;
        }

        if(dp[i][remAmount]!=-1){
            return dp[i][remAmount];
        }

        int take = solve(i, remAmount - coins[i], coins);

        if (take != Integer.MAX_VALUE) {
            take = 1 + take;
        }
        int skip = solve(i+1,remAmount,coins);

        return dp[i][remAmount] = Math.min(take,skip);
        // return Math.min(take,skip);
    }
}