class Solution {

    int m;
    int k;
    int MOD = 1000000007;

    int[][] dp;

    public int numWays(String[] words, String target) {

        k = words[0].length();
        m = target.length();

        dp = new int[m][k];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        int[][] freq = new int[26][k];

        for (int col = 0; col < k; col++) {

            for (String word : words) {
                freq[word.charAt(col) - 'a'][col]++;
            }
        }

        return solve(0, 0, freq, target);
    }

    public int solve(int i, int j, int[][] freq, String target) {

        if (i == m) {
            return 1;
        }

        if (j == k) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int not_taken = solve(i, j + 1, freq, target);

        long taken =
                (long) freq[target.charAt(i) - 'a'][j]
                * solve(i + 1, j + 1, freq, target);

        taken %= MOD;

        return dp[i][j] = (int) ((not_taken + taken) % MOD);
    }
}