class Solution {
    int FEE;
    int n;
    int[][] dp;
    public int maxProfit(int[] prices, int fee) {
        n = prices.length;
        FEE = fee;
        dp = new int[n+1][2];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return solve(0,true,prices);
    }

    public int solve(int i, boolean buy,int[] prices){

        if(i>=n){
            return 0;
        }

        if(dp[i][buy?1:0]!=-1){
            return dp[i][buy?1:0];
        }

        int profit=0;

        if(buy){
            int take = solve(i+1,false,prices)-prices[i];
            int not_take = solve(i+1,true,prices);
            profit = Math.max(profit,Math.max(take,not_take));
        }

        else{
            int sell = prices[i]+solve(i+1,true,prices)-FEE;
            int not_sell= solve(i+1,false,prices);
            profit = Math.max(profit,Math.max(sell,not_sell));
        }
        return dp[i][buy?1:0]=profit;
    }
}