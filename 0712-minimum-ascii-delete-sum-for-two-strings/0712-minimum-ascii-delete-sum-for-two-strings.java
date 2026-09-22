class Solution {
    int m;
    int n;
    int[][] dp;
    public int minimumDeleteSum(String s1, String s2) {
        m = s1.length();
        n = s2.length();
        dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++) {
            for(int j=0;j<=n;j++) {
                Arrays.fill(dp[i],-1);
            }
        }
        return solve(0,0,s1,s2);
    }

    public int solve(int i, int j , String s1, String s2) {
        if(i>=m && j>=n) {
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(i>=m) {
            return s2.charAt(j) + solve(i,j+1,s1,s2);
        }

        if(j>=n) {
            return s1.charAt(i) + solve(i+1,j,s1,s2);
        }

        if(s1.charAt(i)==s2.charAt(j)){
            return solve(i+1,j+1,s1,s2);
        }

        int take_i = s1.charAt(i) + solve(i+1,j,s1,s2);
        int take_j = s2.charAt(j) + solve(i,j+1,s1,s2);


        return dp[i][j] = Math.min(take_i,take_j);
    }
}