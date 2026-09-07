class Solution {
    int[] dp;
    int M = (int)1e9+7;
    public int numTilings(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n);
    }

    public int solve(int n){
        if(n==1 || n==2){
            return n;
        }

        if(n==3){
            return 5;
        }

        if(dp[n]!=-1){
            return dp[n];
        }

        return dp[n] = (2*solve(n-1) % M+solve(n-3) % M) % M;
    }
}