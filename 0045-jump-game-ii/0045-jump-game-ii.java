class Solution {

    int n;
    int[] dp;

    public int jump(int[] nums) {
        n = nums.length;

        dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(nums, 0);
    }

    public int solve(int[] nums, int i) {

        // Reached last index
        if (i == n - 1) {
            return 0;
        }

        // Already calculated
        if (dp[i] != -1) {
            return dp[i];
        }

        int min = n+1;

        for (int j = i + 1;
             j <= Math.min(i + nums[i], n - 1);
             j++) {

            int jumps = solve(nums, j);

            min = Math.min(min, jumps + 1);
        }

        dp[i] = min;

        return dp[i];
    }
}