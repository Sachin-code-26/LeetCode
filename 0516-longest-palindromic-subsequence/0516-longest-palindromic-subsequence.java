class Solution {
    int n;
    int[][] dp;
    public int longestPalindromeSubseq(String s) {
         n = s.length();
         dp = new int[n+1][n+1];
         for(int i=0;i<n;i++) {
            Arrays.fill(dp[i],-1);
         }
        StringBuilder s1 = new StringBuilder(s);
        StringBuilder s2 = new StringBuilder(s).reverse();

        return solve(s1,s2,0,0);
    }

    public int solve(StringBuilder s1, StringBuilder s2 , int i , int j) {
        if(i==n || j==n) {
            return 0;
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=1+solve(s1,s2,i+1,j+1);
        }
        else{
           return dp[i][j]=Math.max(solve(s1,s2,i,j+1),solve(s1,s2,i+1,j));
        }
    }
}