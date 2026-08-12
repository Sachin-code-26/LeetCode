class Solution {
    long[][] dp;
    int n;
    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        boolean flag = true;
       dp = new long[n + 1][2];

        for (int i = 0; i <= n; i++) {
         Arrays.fill(dp[i], -1);
        }

        return solve(0 ,nums, flag);
        
    }

    public long solve(int idx , int[] nums, boolean flag) {
        if(idx>=n) {
            return 0;
        }
        
        int state = flag ? 1 : 0;
        if(dp[idx][state]!=-1) {
            return dp[idx][state];
        }
        long val = nums[idx];
        long skip = solve(idx+1,nums,flag);
       
        if(flag == false) {
            val= -val;
        }

        long take = val+solve(idx+1,nums,!flag);
        

        return dp[idx][state] = Math.max(take,skip);
    }

}