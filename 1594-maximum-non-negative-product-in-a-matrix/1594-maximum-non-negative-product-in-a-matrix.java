class Solution {
    int m;
    int n;
    long MOD = 1_000_000_007L;

    long[][] maxDp;
    long[][] minDp;
    public int maxProductPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        maxDp = new long[m][n];
        minDp = new long[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(maxDp[i], Long.MIN_VALUE);
            Arrays.fill(minDp[i], Long.MAX_VALUE);
        }

        solve(grid, 0, 0);

        long ans = maxDp[0][0];

        if (ans < 0) {
            return -1;
        }

        return (int)(ans % MOD);
    }

    public void solve(int[][] grid , int i, int j) {
        
        if(i>=m || j>=n) {
            return;
        }

        if(i==m-1 && j==n-1) {
            maxDp[i][j]=grid[i][j];
            minDp[i][j]=grid[i][j];
            return;
        }

        if (maxDp[i][j] != Long.MIN_VALUE) {
            return;
        }

        solve(grid,i,j+1);
        solve(grid,i+1,j);

        long value = grid[i][j];

        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        if(i+1<m) {
            max = Math.max(max,value*maxDp[i+1][j]);
            max = Math.max(max,value*minDp[i+1][j]);

            min = Math.min(min,value*minDp[i+1][j]);
            min = Math.min(min,value*maxDp[i+1][j]);

        }

        if(j+1<n) {
            max = Math.max(max,value*maxDp[i][j+1]);
            max = Math.max(max,value*minDp[i][j+1]);

            min = Math.min(min,value*minDp[i][j+1]);
            min = Math.min(min,value*maxDp[i][j+1]);

        }

        maxDp[i][j] = max;
        minDp[i][j] = min;


    }
}