class Solution {
    int M = (int)1e9+7;
    int n;
    int[][]dp;
    public int numWays(int steps, int arrLen) {
        arrLen = Math.min(steps+1,arrLen);
        n = arrLen;

        dp = new int[steps+1][n+1];
        for(int i=0;i<=steps;i++) {
            for(int j=0;j<=n;j++){
                Arrays.fill(dp[i],-1);
            }
        }
       return solve(steps,0);
    }

    public int solve(int steps, int i) {
        if(i<0 || i>=n) {
            return 0;
        }

        if(dp[steps][i]!=-1){
            return dp[steps][i];
        }

        if(steps==0) {
            if(i==0){
                return 1;
            }

            return 0;
        }

        int right=solve(steps-1,i+1)%M;
        int left=solve(steps-1,i-1)%M;
        int stay=solve(steps-1,i)%M;

        return dp[steps][i] =
            (int) (((long) left + right + stay) % M);

    }
}