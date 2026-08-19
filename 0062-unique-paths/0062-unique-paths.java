class Solution {
    int[][] dirn ={
        {0,1},
        {1,0}
    };
    int M;
    int N;
    int[][] dp;
    public int uniquePaths(int m, int n) {
         M=m;
         N= n;
         dp = new int[m][n];
         for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
         }
        int[][] grid = new int[M][N];
        return solve(grid, 0 , 0);
        
    }

    public int solve(int[][] grid , int i, int j) {
        if(i>=M || j>=N) {
            return 0;
        }
        if(i==M-1 && j==N-1){
            return 1;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int ways = 0;
        for(int[] dir : dirn){
            int new_x = i+dir[0];
            int new_y = j+dir[1];

            ways+=solve(grid,new_x,new_y);
        }
        dp[i][j] = ways;

        return dp[i][j];
    }
}