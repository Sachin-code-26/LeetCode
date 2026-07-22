class Solution {
    public int minimumObstacles(int[][] grid) {
        int[][] direction = { 
            {0,1}, {0,-1} , {1,0} , {-1,0}
        };
        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m][n];
        for (int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        result[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        pq.offer(new int[]{0,0,0});// wt ,i,j

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int obstacleCount = curr[0];
            int i=curr[1];
            int j=curr[2];

            for(int[] dirn : direction) {
                int x = i+dirn[0];
                int y = j+dirn[1];

                if(x>=0 && x<m && y>=0 && y<n) {
                    int wt = (grid[x][y] == 1) ? 1 : 0;

                    if(result[x][y]>obstacleCount + wt) {
                       result[x][y] = obstacleCount + wt;
                       pq.offer(new int[]{ obstacleCount + wt , x, y});
                    }
                }
            }
        }

        return result[m-1][n-1];
    }
}