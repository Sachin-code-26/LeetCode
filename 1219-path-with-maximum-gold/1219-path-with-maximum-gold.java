class Solution {
    int m;
    int n;
    int[][] dirn = {
        {-1,0} , {0,1} , {1,0} , {0,-1}
    };
    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        int maxgold=0;
        n = grid[0].length;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]!=0) {
                    maxgold = Math.max(maxgold,dfs(grid,i,j));
                }
            }
        }

        return maxgold;
    }

    public int dfs(int[][] grid , int i, int j) {

        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]==0) {
            return 0;
        }

        int maxgold=0;

        int orival= grid[i][j];
        grid[i][j]=0;

        for(int[] dir : dirn) {
            int new_i = i+dir[0];
            int new_j = j+dir[1];

            maxgold = Math.max(maxgold,dfs(grid, new_i , new_j));
        }
        grid[i][j]=orival;
        return orival+maxgold;
    }
}