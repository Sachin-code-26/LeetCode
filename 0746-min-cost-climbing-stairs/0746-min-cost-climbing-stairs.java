class Solution {
    int n;
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        n = cost.length;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(solve(0,cost),solve(1,cost));
    }

    public int solve(int i, int[] cost){
        if(i>=n){
            return 0;
        }

        if(dp[i]!=-1){
            return dp[i];
        }

        int take_1step = cost[i] + solve(i+1,cost);
        int take_2step = cost[i] + solve(i+2,cost);

        return dp[i] = Math.min(take_1step,take_2step);
    }
}