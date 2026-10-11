class Solution {
    int n;
    int[][][][] dp;
    public int getLengthOfOptimalCompression(String s, int k) {
        n = s.length();
         dp = new int[n][27][101][k+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 27; j++) {
                for (int p = 0; p < 101; p++) {
                    Arrays.fill(dp[i][j][p], -1);
                }
            }
        }
        return solve(s,0,26,0,k);
    }

    public int solve(String s , int i , int prev, int freq, int k) {
        if(k<0) {
             return 100000;
        }

        if(i>=n) {
            return 0;
        }

        if (dp[i][prev][freq][k] != -1) {
            return dp[i][prev][freq][k];
        }

        int delete_i = solve(s,i+1,prev,freq,k-1);

        int keep_i = 0;

        if((s.charAt(i)-'a')!=prev) {
            keep_i = 1+solve(s,i+1,s.charAt(i)-'a',1,k);
        }
        else {
            int one_more_addition = 0;

            if(freq==1 || freq==9 || freq==99) {
                one_more_addition = 1;
                
            }
             keep_i = one_more_addition +solve(s,i+1,prev,freq+1,k);
        }

       

        return dp[i][prev][freq][k] = Math.min(keep_i,delete_i);
    }
}