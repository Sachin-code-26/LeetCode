class Solution {
    int n;
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
          n = nums.length;
          dp = new int[n+1][n+1];
          for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
          }

        return solve(nums, 0 , -1);
    }

    public int solve(int[] nums , int i , int prev) {
        if(i>=n){
            return 0;
        }

        if(prev!=-1 && dp[i][prev]!=-1){
            return dp[i][prev];
        }
        int take = 0;
        if(prev==-1 || nums[i]>nums[prev]) {
           take = 1+solve(nums,i+1,i);
        }

        int skip = solve(nums,i+1,prev);
        
        if(prev!=-1){
            dp[i][prev]=Math.max(take,skip);
        }

        return Math.max(take,skip);

    }
}