class Solution {
    Set<String> set = new HashSet<>();
    int n;
    int[] dp;
    public int minExtraChar(String s, String[] dictionary) {
        n = s.length();
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        for(String st : dictionary) {
            set.add(st);
        }
        return solve(0,s);
    }

    public int solve(int idx, String s) {
        if(idx>=n) {
            return 0;
        }

        if(dp[idx]!=-1){
            return dp[idx];
        }

        StringBuilder sb = new StringBuilder();
        int minExtra=n;

        for(int i=idx;i<n;i++) {
            sb.append(s.charAt(i));

            int currExtra =0;

            if(!set.contains(sb.toString())){
                currExtra = sb.length();
            }

            int nextExtra=solve(i+1,s);

            int total = currExtra+nextExtra;

            minExtra = Math.min(minExtra,total);
        }

        return dp[idx]=minExtra;
    }
}