class Solution {
    double[][]dp;
    public double champagneTower(int poured, int query_row, int query_glass) {
       
        dp = new double[101][101];
        for(int i=0;i<101;i++) {
            for(int j=0;j<101;j++) {
                Arrays.fill(dp[i],-1);
            }
        }
        return Math.min(1.0, solve(poured, query_row, query_glass));
    }


    public double solve(int poured, int i , int j) {
        if(i<0 || j<0 || i<j) {
            return 0;
        }

        if(i==0 && j==0) {
            return poured;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        double top_left = (solve(poured,i-1,j-1)-1)/2;
        double top_right = (solve(poured,i-1,j)-1)/2;

        if(top_left<0){
            top_left = 0;
        }

         if(top_right<0){
            top_right = 0;
        }

        return dp[i][j] = top_left+top_right;
    } 

}