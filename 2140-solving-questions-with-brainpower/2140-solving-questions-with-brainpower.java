class Solution {
    int n;
    long[] dp;
    public long mostPoints(int[][] questions) {
        n = questions.length;
        dp = new long[n+1];
        Arrays.fill(dp,-1);
        return solve(0,questions);
    }


    public long solve(int i , int[][] questions) {
        if(i>=n) {
            return 0;
        }

        if(dp[i]!=-1){
            return dp[i];
        }

        long take = questions[i][0] + solve(i+questions[i][1]+1,questions);
        long skip = solve(i+1,questions);

        return dp[i] = Math.max(take,skip);
    }
}