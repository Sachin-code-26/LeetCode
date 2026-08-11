class Solution {
    int n;
    int[] dp;
    public int rob(int[] nums) {
        n=nums.length;
        dp = new int[n+1];
        Arrays.fill(dp,-1);

      return solve(nums,0);
    }

    public int solve(int[] nums, int idx) {
        if(idx>=n){
            return 0;
        }

        if(dp[idx]!=-1){
            return dp[idx];
        }

        int take = nums[idx] + solve(nums,idx+2);
        int skip = solve(nums,idx+1);

        return dp[idx] = Math.max(take,skip);
    }
}