class Solution {
    int n;
    int[][] dp;
    public int longestStrChain(String[] words) {
        n=words.length;
        dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        Arrays.sort(words, (a, b) -> {
             return Integer.compare(a.length(), b.length());
            });
       return solve(words,0 , -1);
    }

    public int solve(String[] words , int i , int prev) {
        if(i>=n){
            return 0;
        }

        if( prev!=-1 && dp[i][prev]!=-1){
            return dp[i][prev];
        }
        int take = 0;
        if(prev==-1 || isPred(words,i,prev)) {
            take = 1 + solve(words,i+1,i);
        }

        int skip = solve(words,i+1,prev);

        if(prev!=-1) {
            dp[i][prev]=Math.max(take,skip);
        }
        return Math.max(take,skip);
    }

    public boolean isPred(String[] words ,int curr , int prev) {
        int N = words[curr].length();
        int M = words[prev].length();

        int i=0,j=0;

        if((M+1)!=N){
            return false;
        }

        while(i<N && j<M) {
            if((words[curr].charAt(i))==(words[prev].charAt(j))){
                j++;
            }
            i++;
        }

        if(j==M){
            return true;
        }

        return false;
    }
}