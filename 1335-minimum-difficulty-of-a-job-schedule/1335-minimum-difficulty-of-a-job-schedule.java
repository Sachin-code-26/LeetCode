class Solution {
    int[][] dp;
    public int minDifficulty(int[] job, int d) {
        int n = job.length;

      
        if(d>n){
            return -1;
        }

        dp= new int[n+1][d+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(job,0,d);
    }

    public int solve(int[] jobs , int idx , int d) {

        if(dp[idx][d]!=-1){
            return dp[idx][d];
        }
        if(d==1){
            int max = 0;
            for(int i=idx;i<jobs.length;i++){
                max= Math.max(max,jobs[i]);
            }
            return max;
        }

        int maxD = Integer.MIN_VALUE;
        int result = Integer.MAX_VALUE;
        for(int i=idx;i<=jobs.length-d;i++){
            maxD = Math.max(maxD, jobs[i]);
            result = Math.min(result, maxD+solve(jobs , i+1,d-1));
        }

        return dp[idx][d] = result;
    }
}