class Solution {
    int n;
    int[][][] dp;
    public int stoneGameII(int[] piles) {
         n = piles.length;
         dp = new int[n+1][n+1][2];
         for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                Arrays.fill(dp[i][j],-1);
            }
         }
        return solve(0,1,piles,1);
    }

    public int solve(int i, int person , int[] piles , int M){

        if(i>=n){
            return 0;
        }

        if(dp[i][M][person]!=-1){
            return dp[i][M][person];
        }

        int score =0;
        int result = (person==1)?-1:Integer.MAX_VALUE;

        for(int x=1;x<=Math.min(2*M,n-i);x++){

            score+=piles[i+x-1];

            if(person ==1 ){
               result = Math.max(result, score + solve(i+x, 0 ,piles, Math.max(M,x)));
            }
            else {
                result = Math.min(result,solve(i+x,1,piles,Math.max(M,x)));
            }
        }

        return dp[i][M][person] = result;
    }
}