class Solution {
    int N;
    int[][][] dp;
    int M = (int)1e9+7;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        N = n;
        dp = new int[group.length+1][n+1][minProfit+1];

        for(int i=0;i<=group.length;i++){
            for(int people = 0;people<=n;people++){
                Arrays.fill(dp[i][people],-1);
            }
        }


        return solve(0,0,0, n, minProfit, group, profit);
    }


    public int solve(int i, int people, int p , int n, int minProfit, int[] group, int[] profit){

        if(people>N) {
            return 0;
        }

        

        if(i==group.length){

            if(p>=minProfit){
            return 1;
            }
            return 0;
        }

        if(dp[i][people][p]!=-1){
            return dp[i][people][p];
        }

        

        int not_taken = solve(i+1,people, p, n , minProfit, group , profit) % M;

        int taken = solve(i+1,people+group[i], Math.min(p+profit[i],minProfit),n, minProfit, group , profit) % M ;

        return dp[i][people][p] = (taken + not_taken)%M;
    }
}