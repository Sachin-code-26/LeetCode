class Solution {
    int n;
    int[][] dp;
    public int maxSatisfaction(int[] satisfaction) {
        n = satisfaction.length;
        dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        Arrays.sort(satisfaction);
        return solve(satisfaction,0,1);
    }

    public int solve(int[] satisfaction , int i , int t) {
        if(i==n){
            return 0;
        }

        if(dp[i][t]!=-1){
            return dp[i][t];
        }

        int take = satisfaction[i]*t + solve(satisfaction,i+1,t+1);
        int skip = solve(satisfaction,i+1,t);


        return dp[i][t] = Math.max(take,skip);
    }
}