class Solution {
    int n;
    Boolean[][] dp;
    HashMap<Integer,Integer> map = new HashMap<>();
    public boolean canCross(int[] stones) {
        n = stones.length;
        dp = new Boolean[n+1][n+1];
        for(int i=0; i<n;i++) {
            map.put(stones[i],i);
        }

        return solve(stones,0,0);
    }

    public boolean solve(int[] stones , int curr_stones_idx, int prevJump) {

        if(curr_stones_idx==n-1) {
            return true;
        }

        if(dp[curr_stones_idx][prevJump]!=null) {
            return dp[curr_stones_idx][prevJump];
        }

        boolean result = false;


        for(int nextJump = prevJump-1; nextJump<=prevJump+1;nextJump++) {

            if(nextJump>0) {
                int nextStone = stones[curr_stones_idx] + nextJump;

                if(map.containsKey(nextStone)) {
                result = result || solve(stones,map.get(nextStone),nextJump);
                }
            }
            
        }

        return dp[curr_stones_idx][prevJump]=result;
    }
}