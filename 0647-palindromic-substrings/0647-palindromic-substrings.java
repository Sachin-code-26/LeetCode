class Solution {
    boolean[][] dp;
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        dp = new boolean[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],false);
        }

        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                if(check(s,i,j)){
                    count++;
                }
            }
        }

        return count;
    }

    public boolean check(String s , int i , int j){
        if(i>j){
            return true;
        }

        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j] = check(s,i+1,j-1);
        }

        return dp[i][j] = false;
    }
}