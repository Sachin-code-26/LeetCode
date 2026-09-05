class Solution {
    int m;
    int n;
    int[][] dp;
    public int minFallingPathSum(int[][] matrix) {
         m = matrix.length;
         n = matrix[0].length;
         dp = new int[m+1][n+1];
         for(int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int row = 0;
        int ans = Integer.MAX_VALUE;
        for(int col=0;col<n;col++) {
            ans = Math.min(ans,solve(matrix, row , col));
        }

        return ans;
    }

    public int solve(int[][] matrix , int row , int col) {
        if(row == m-1) {
            return matrix[row][col];
        }

        if(dp[row][col]!=Integer.MAX_VALUE){
            return dp[row][col];
        }

        int minSum = Integer.MAX_VALUE;

        if(row+1<m && col-1>=0) {
            minSum = Math.min(minSum,(matrix[row][col] + solve(matrix , row+1, col-1)));
        }

        if(row+1<m && col>=0) {
           minSum = Math.min(minSum,(matrix[row][col] + solve(matrix , row+1, col)));
        }

        if(row+1<m && col+1<n) {
           minSum = Math.min(minSum,(matrix[row][col] + solve(matrix , row+1, col+1)));
        }

        return dp[row][col] = minSum;
    }
}