class Solution {
    int n;
    int[] dp;
    public String stoneGameIII(int[] stoneValue) {
        n = stoneValue.length;

        dp = new int[n+1];
        Arrays.fill(dp,-1);
        int diff =solve(0,stoneValue);

        if(diff>0){
            return "Alice";
        }

        else if(diff<0){
            return "Bob";
        }

        else {
            return "Tie";
        }
    }

    public int solve(int i, int[] stoneValue) {
        if(i>=n){
            return 0;
        }

        if(dp[i]!=-1){
            return dp[i];
        }

        int result = stoneValue[i] - solve(i+1,stoneValue);
        if(i+1<n){
            result = Math.max(result, stoneValue[i]+stoneValue[i+1]-solve(i+2,stoneValue));
        }
        
        if(i+2<n){
            result = Math.max(result, stoneValue[i]+stoneValue[i+1]+stoneValue[i+2]-solve(i+3,stoneValue));
        }
        
        return dp[i] = result;
    }
}