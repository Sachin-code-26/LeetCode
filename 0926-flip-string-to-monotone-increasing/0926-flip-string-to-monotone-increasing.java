class Solution {
    int n;
    int[][]dp;
    public int minFlipsMonoIncr(String s) {
        n = s.length();
        dp = new int[n+1][2];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(s,0,0);
    }

    public int solve(String s , int i , int prev) {
        if(i>=n){
            return 0;
        }

        if(dp[i][prev]!=-1){
            return dp[i][prev];
        }

        int flip = Integer.MAX_VALUE;
        int notFlip = Integer.MAX_VALUE;;

        if(s.charAt(i)=='0'){

            if(prev==1){
                flip = 1+solve(s,i+1,1);
            }

            else if(prev==0){
                 flip = 1 + solve(s,i+1,1);
                 notFlip = solve(s,i+1,0);
            }
        }

        else if(s.charAt(i)=='1'){

            if(prev==1){
                notFlip = solve(s,i+1,1);
            }

            else if(prev==0){
                 flip = 1 + solve(s,i+1,0);
                notFlip = solve(s,i+1,1);
            }
        }

        return dp[i][prev] = Math.min(flip,notFlip);
    }
}