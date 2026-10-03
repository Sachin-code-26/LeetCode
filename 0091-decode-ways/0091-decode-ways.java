class Solution {
    int n;
    int[] dp;
    public int numDecodings(String s) {
        n = s.length();
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(0,s);
    }

    public int solve(int i, String s) {
        if(i>=n) {
            return 1;
        }

        if(s.charAt(i)=='0') {
            return 0;
        }

        if(dp[i]!=-1){
            return dp[i];
        }

        int only_ith_char = solve(i+1,s);

        int ith_plus_1char = 0;

        if(i+1<n) {
           if(s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<='6')) {
            ith_plus_1char = solve(i+2,s);
           } 
        }

        int ans = only_ith_char + ith_plus_1char;
        return dp[i] = ans;
    }
}