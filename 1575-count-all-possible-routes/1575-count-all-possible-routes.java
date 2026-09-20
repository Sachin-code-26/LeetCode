class Solution {
    int n;
    int[][] dp;
    int M = (int)1e9+7;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {

        n = locations.length;
        dp = new int[n+1][fuel+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(start,finish,fuel,locations);
        
    }

    public int solve(int i, int finish, int fuel , int[] locations) {
        if(fuel<0){
            return 0;
        }

        if(dp[i][fuel]!=-1){
            return dp[i][fuel];
        }

        int ans =0;

        if(i==finish) {
            ans++;
        }

        for(int j=0;j<n;j++){
            int rem_fuel = fuel-Math.abs(locations[j]-locations[i]);
            if(j!=i){
                ans=(ans + solve(j,finish,rem_fuel,locations))%M;
            }
        }

        return dp[i][fuel] = ans;
    }
}