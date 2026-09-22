class Solution {
    int n;
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        n = s.length();
        dp= new Boolean[n+1];

        return solve(0,s,wordDict);
    }

    public boolean solve(int idx, String s, List<String> wordDict) {
        if(idx>=n) {
            return true;
        }

        if(dp[idx]!=null) {
            return dp[idx];
        }

        for(int endIdx=idx+1;endIdx<=n;endIdx++) {
            String word = s.substring(idx,endIdx);

            if(wordDict.contains(word) && solve(endIdx,s,wordDict)) {
                return dp[idx] = true;
            }
        }

        return dp[idx] = false;
    }
}