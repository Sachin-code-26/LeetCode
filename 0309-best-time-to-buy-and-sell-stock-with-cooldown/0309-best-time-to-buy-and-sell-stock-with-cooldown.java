class Solution {
    int[][]dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        boolean buy = true;
        dp = new int[n+1][2];
        for(int i =0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(prices, 0 , n, buy);
    }

    public int solve(int[] prices , int i , int n, boolean buy){

        if(i>=n){
            return 0;
        }
        
        if(dp[i][buy? 1:0]!=-1){
            return dp[i][buy?1:0];
        }
        int profit = 0;

        if(buy){
            int take = solve(prices, i+1 , n, false)-prices[i];
            int not_take = solve(prices,i+1,n,true);
            profit=Math.max(take,not_take);
        }
        else{
            int sell = solve(prices,i+2,n,true)+prices[i];
            int not_sell = solve(prices,i+1,n ,false);
            profit=Math.max(sell,not_sell);
        }

        return dp[i][buy?1:0] = profit;
    }
}