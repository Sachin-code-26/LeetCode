class Solution {
    int n;
    Boolean[] dp;
    public boolean validPartition(int[] nums) {
        n = nums.length;
        dp = new Boolean[n+1];
    
        return solve(0,nums);
    }

    public boolean solve(int i , int[] nums) {
        if(i>=n){
            return true;
        }

        if(dp[i]!=null){
            return dp[i];
        }

        boolean result = false;

        if(i+1<n && nums[i]==nums[i+1]){
            result = solve(i+2,nums);
        }

        if(result==true) {
            return true;
        }


        if (i+2<n && nums[i] == nums[i+1] && nums[i+1] == nums[i+2]) {
            result = solve(i+3,nums);
        }

        if(result==true) {
            return true;
        }

        if(i+2<n && nums[i+1]-nums[i]==1 && nums[i+2]-nums[i+1]==1) {
            result = solve(i+3,nums);
        }

        return dp[i] = result;
    }
}