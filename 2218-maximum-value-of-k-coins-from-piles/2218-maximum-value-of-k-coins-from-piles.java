class Solution {
    int n;
    int[][] dp;
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        n = piles.size();
        dp = new int[n+1][k+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
       return solve(piles , 0, k);
    }

    public int solve(List<List<Integer>> piles, int i, int k) {
        if(i>=n){
            return 0;
        }

        if(dp[i][k]!=-1){
            return dp[i][k];
        }

        int not_taken = solve(piles, i+1, k);

        //taken
        int sum =0;
        int taken =0;

        for(int j=0;j<Math.min(piles.get(i).size(),k);j++) {
            sum+= piles.get(i).get(j);

            if(k-(j+1)>=0){
                taken = Math.max(taken,sum + solve(piles , i+1 , k-(j+1)));
            }
        }

        return dp[i][k] = Math.max(taken,not_taken);
    }

}