class Solution {
    int m;
    int n;
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] grid) {
       m = grid.length;
       n = grid[0].length; 
       dp = new int[m][n];
       for(int i=0;i<m;i++){
        Arrays.fill(dp[i],-1);
       }

       return solve(grid, 0 , 0);
    }

    public int solve(int[][] grid , int i , int j) {
        if(i>=m || j>=n || grid[i][j]==1) {
            return 0;
        }

        if(i==m-1 && j==n-1){
            return 1;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int right = solve(grid, i, j+1);
        int down = solve(grid, i+1, j);

        return dp[i][j] = right+down;
    }


}