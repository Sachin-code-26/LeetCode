class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int[][] grid = new int[n+1][n+1];
        for (int[] row : grid) {
            Arrays.fill(row, 100000);
        }
          for (int i = 1; i <= n; i++){
            grid[i][i] = 0;
          }
        for(int i=1;i<n;i++){
            grid[i][i+1]=1;
            grid[i+1][i]=1;
        }

        grid[x][y]=1;
        grid[y][x]=1;

        for(int via=1;via<=n;via++) {
            
            for(int i=1;i<=n;i++) {

                for(int j=1;j<=n;j++) {

                    grid[i][j] = Math.min(grid[i][j], grid[i][via]+grid[via][j]);
                }
            }
        }

        int[] res = new int[n];

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(i==j) {
                    continue;
                }
                int val=grid[i][j];
                res[val-1]++;
            }
        }

        return res;
    }
}