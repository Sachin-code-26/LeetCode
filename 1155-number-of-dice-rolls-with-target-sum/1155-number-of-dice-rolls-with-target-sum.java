class Solution {
    int[][] dp;
    int M=(int)1e9+7;
    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[n+1][target+1];
        for(int[] row: dp) {
            Arrays.fill(row,-1);
        }
        return solve(n,k,target);
    }

    public int solve(int n , int k , int target) {
        if(n==0) {
            return target == 0?1:0;
        }

        if(target<0) {
            return 0;
        }

        if(dp[n][target]!=-1) {
            return dp[n][target];
        }

        int ans=0;

        for(int face=1;face<=k;face++) {
            ans= (ans%M + solve(n-1,k,target-face)%M)%M;
        }

        return dp[n][target] = ans;
    }
}