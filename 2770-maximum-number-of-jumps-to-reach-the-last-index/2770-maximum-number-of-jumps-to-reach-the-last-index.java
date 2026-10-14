class Solution {
    int n;
    int M = Integer.MIN_VALUE;
    int[] dp;
    public int maximumJumps(int[] nums, int target) {
        n = nums.length;
        dp = new int[n+1];
        Arrays.fill(dp,M);
        int result = solve(0,nums,target);
        return result<0?-1:result;
    }

    public int solve(int i , int[] nums, int target) {
        if(i==n-1) {
            return dp[i] = 0;
        }

        if(dp[i]!=M) {
            return dp[i];
        }

        int result = Integer.MIN_VALUE;

        for(int j=i+1;j<n;j++) {
            if(Math.abs(nums[j]-nums[i])<=target) {
                  int temp = 1 + solve(j,nums,target);
                  result = Math.max(result,temp);
            }
          
        }

        return dp[i] = result;
    }
}