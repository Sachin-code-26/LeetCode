class Solution {
    int n;
    int[] dp;
    public int mincostTickets(int[] days, int[] costs) {
        n = days.length;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
       return solve(0 , days, costs);
    }

    public int solve(int i , int[] days , int[] costs) {
        if(i>=n){
            return 0;
        }
        

        if(dp[i]!=-1){
            return dp[i];
        }

        //1day pass

        int cost_1day = costs[0] + solve(i+1,days,costs);

        // 7 day pass;
        int j = i;
        int max_day = days[i]+7;

        while(j<n && days[j]<max_day){
            j++;
        }

        int cost_7day = costs[1]+ solve(j,days,costs);

        // 30 day pass

        j = i;
         max_day = days[i]+30;

        while(j<n && days[j]<max_day){
            j++;
        }

        int cost_30day = costs[2]+ solve(j,days,costs);

        return dp[i]=Math.min(cost_1day,Math.min(cost_7day,cost_30day));
    }
}