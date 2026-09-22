class Solution {

    int[][] serves = {
        {100, 0},
        {75, 25},
        {50, 50},
        {25, 75}
    };

    double[][] dp;

    public double solve(int A, int B) {

        if (A <= 0 && B <= 0)
            return 0.5;

        if (A <= 0)
            return 1.0;

        if (B <= 0)
            return 0.0;

        if (dp[A][B] != -1.0)
            return dp[A][B];

        double probability = 0.0;

        for (int[] serve : serves) {

            int A_serve = serve[0];
            int B_serve = serve[1];

            probability += 0.25 * solve(A - A_serve, B - B_serve);
        }

        return dp[A][B] = probability;
    }

    public double soupServings(int n) {

        if (n >= 5000)
            return 1.0;

        dp = new double[n + 1][n + 1];

        for (double[] row : dp) {
            Arrays.fill(row, -1.0);
        }

        return solve(n, n);
    }
}