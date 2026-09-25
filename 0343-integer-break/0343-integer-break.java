class Solution {
    int[]dp;
    public int integerBreak(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n);
    }

    public int solve(int n) {
        if(n==0){
            return 0;
        }

        if(dp[n]!=-1){
            return dp[n];
        }

        
        int result=1;
        for(int i=1;i<n;i++){
            
            int take_i = i*solve(n-i);
            int prod=Math.max(i*(n-i),take_i);
            result = Math.max(prod,result);
        }

        return dp[n] = result;
    }
}