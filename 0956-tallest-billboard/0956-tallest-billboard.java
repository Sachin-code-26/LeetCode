class Solution {
    int n;
    int[][] dp;
    public int tallestBillboard(int[] rods) {
        n = rods.length;
        dp = new int[n+1][10003];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return solve(0,0,rods)/2;
    }

    public int solve(int i, int diff ,int[] rods) {
        if(i>=n){
            if(diff==0){
                return 0;
            }

            return Integer.MIN_VALUE;
        }

        if(dp[i][diff+5000]!=-1){
            return dp[i][diff+5000];
        }

        

        int left = rods[i] + solve(i+1,diff+rods[i],rods);
        int right = rods[i] + solve(i+1,diff-rods[i],rods);
        int nothing = solve(i+1,diff, rods);


        int ans = Math.max(left, Math.max(right, nothing));
        return dp[i][diff+5000] = ans;
    }
}