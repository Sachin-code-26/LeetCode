class Solution {
    int[][] dp;
    int[][] adj = {
        {4,6},
        {6,8},
        {7,9},
        {4,8},
        {0,3,9},
        {},
        {0,1,7},
        {2,6},
        {1,3},
        {2,4}

    };
    int M = (int)1e9+7;
    public int knightDialer(int n) {
        int result = 0;
        dp = new int[10][n+1];
        for(int i=0;i<10;i++){
            
                Arrays.fill(dp[i],-1);
            
        }
        for(int i=0;i<=9;i++) {
            result=(result+solve(i,n-1))%M;
        }
        return result;
    }

    public int solve(int i , int steps) {
        if(steps==0) {
            return 1;
        }

        if(dp[i][steps]!=-1) {
            return dp[i][steps];
        }

        int ans = 0;

        for(int next: adj[i]) {
            ans=(ans+solve(next,steps-1))%M;
        }

        return dp[i][steps]=ans;
    }
}