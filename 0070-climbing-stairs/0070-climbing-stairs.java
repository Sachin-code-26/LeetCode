class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        solve(n);
        return dp[n]; 
    }

    public int solve(int n){
        
        if(n==0){
            return 1;
        }

        if(n<0){
            return 0;
        }

        if(dp[n]!=-1){
            return dp[n];
        }

        int one_step = solve(n-1);
        int two_step = solve(n-2);

         return dp[n]= one_step+two_step;

    }
}