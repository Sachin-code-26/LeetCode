class Solution {
    int N;
    int M;
    int K;
    int MOD = 1000000007;
    int[][][] dp;
    public int numOfArrays(int n, int m, int k) {
        N = n;
        M = m;
        K = k;
        dp = new int[n+1][n+1][m+1];

         for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(0,0,0);
    }

    public int solve(int idx, int searchScore, int maxScore) {

        if(idx==N) {

            if(searchScore == K){
                return 1;
            }
            return 0;
        }

        if (dp[idx][searchScore][maxScore] != -1) {
            return dp[idx][searchScore][maxScore];
        }

         int result = 0;
        for(int i=1;i<=M;i++) {

            if(i>maxScore) {
              result = (result + solve(idx+1, searchScore + 1 , i))%MOD;
            }

            else { 
                result  = (result + solve(idx+1, searchScore, maxScore))% MOD;
                }
        }

        return dp[idx][searchScore][maxScore] = result % MOD;
    }
}