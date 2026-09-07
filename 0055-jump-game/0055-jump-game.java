class Solution {
    int n;
    int[] dp;
    public boolean canJump(int[] nums) {
        n = nums.length;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(nums, 0);
    }

    public boolean solve(int[] nums , int i) {
        if(i>=n){
            return false;
        }

        if(i==n-1){
            return true;
        }

        if(dp[i]!=-1){
            return dp[i]==1;
        }

        for(int j=i+1;j<=i+nums[i];j++){
            if(solve(nums,j)){
                dp[j] = 1;
                return true;
            }
        }

        dp[i]=0;
        return false;
    }
}