class Solution {
    int n;
    int M;
    int[] dp;
    public int numberOfArrays(String s, int k) {
        n = s.length();
        M = (int)1e9+7;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(0,s,k);
    }

    public int solve(int i , String s , int k) {
        if(i>=n) {
            return 1;
        }

        if(dp[i]!=-1){
            return dp[i];
        }

        if(s.charAt(i)=='0'){
            return 0;
        }

        long ans = 0;

        long num = 0;

        for(int end = i;end<s.length();end++) {

            num = (num*10) + (s.charAt(end)-'0');
            
            if(num > k){
                break;
            }

           ans= (ans%M + solve(end+1,s,k)%M)%M;
        }

        return dp[i] = (int)ans;
    }
}