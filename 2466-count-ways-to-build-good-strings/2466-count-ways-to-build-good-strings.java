class Solution {
    int count = 0;
    int[] dp;
    int M = (int)1e9+7;
    public int countGoodStrings(int low, int high, int zero, int one) {
        dp = new int[high+1];
        Arrays.fill(dp,-1);
        return solve(0,low,high,zero,one);
        
    }

    public int solve(int len , int low, int high, int zero, int one){

        if(len>high) {
            return 0;
        }

        if(dp[len]!=-1){
            return dp[len];
        }

        if(len>=low && len<=high){
            return dp[len] = (1+solve(len+one ,low,high,zero,one)%M+ solve(len+zero ,low,high,zero,one)%M)%M;
        }

        //take one
        int take_one = solve(len+one ,low,high,zero,one)%M;

        //take zero

        int take_zero = solve(len+zero ,low,high,zero,one)%M;

        return dp[len] = (take_one+take_zero)%M;
    }
}