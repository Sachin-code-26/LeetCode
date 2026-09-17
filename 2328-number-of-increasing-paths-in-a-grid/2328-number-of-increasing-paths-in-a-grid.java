class Solution {
    int[][] dirn = {
        {-1,0}, {0,1} , {1,0}, {0,-1}
    };
    int m;
    int n;
    int[][] dp;
    int M = (int)1e9+7;
    public int countPaths(int[][] grid) {
         m = grid.length;
         n = grid[0].length;
        int sum = 0;
        dp = new int[m+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i],-1);
            }
        }
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                sum=(sum%M+solve(i,j,grid)%M)%M;
            }
        }

        return sum;
    }

    public int solve(int i, int j, int[][] grid){

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int count = 1;
        for(int[] dir: dirn){
            int new_i = i+dir[0];
            int new_j = j+dir[1];
            if(isSafe(new_i,new_j) && grid[new_i][new_j]>grid[i][j]){
                count=(count+solve(new_i,new_j,grid)%M)%M;
            }
        }

        return dp[i][j] = count;
    }

    public boolean isSafe(int i , int j){
        if(i<0|| j<0 || i>=m || j>=n){
            return false;
        }

        return true;
    }
}