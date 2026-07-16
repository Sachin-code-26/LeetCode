class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        return solve(triangle, 0, 0, dp);
    }

    public int solve(List<List<Integer>> triangle, int row, int col, int[][] dp) {
        int n = triangle.size();

        if (row == n - 1) {
            return triangle.get(row).get(col);
        }

        if (dp[row][col] != Integer.MIN_VALUE) {
            return dp[row][col];
        }

        int down = solve(triangle, row + 1, col, dp);
        int diagonal = solve(triangle, row + 1, col + 1, dp);

        dp[row][col] = triangle.get(row).get(col) + Math.min(down, diagonal);

        return dp[row][col];
    }
}