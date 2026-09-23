class Solution {
    int m, n, N;
    Boolean[][][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        m = s1.length();
        n = s2.length();
        N = s3.length();

        dp = new Boolean[m+1][n+1][N+1];

        if(m+n!=N){
            return false;
        }

        return solve(0,0,0,s1,s2,s3);
    }

    public boolean solve(int i, int j, int k , String s1, String s2, String s3){

        if(i>=m && j>=n && k>=N){
            return true;
        }

        if(k>=N) {
            return false;
        }

        if(dp[i][j][k]!=null) {
            return dp[i][j][k];
        }

        boolean result = false;

        if(i<m && s1.charAt(i)==s3.charAt(k)){
            result = result || solve(i+1,j,k+1,s1,s2,s3);
        }

        // if(result = true) {
        //     return dp[i][j][k] = true;
        // }

        if(j<n && s2.charAt(j)==s3.charAt(k)){
            result = result || solve(i,j+1,k+1,s1,s2,s3);
        }

        return dp[i][j][k] = result;
    }
}