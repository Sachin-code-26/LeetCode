class Solution {
    int n;
    int[][]dp;
    public int maxValue(int[][] events, int k) {
        n = events.length;
        dp = new int[n+1][k+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        return solve(0,k,events);

    }


    public int solve(int i , int k, int[][] events) {
        if(i>=n || k==0) {
            return 0;
        }

        if(dp[i][k]!=-1){
            return dp[i][k];
        }

        int skip = solve(i+1, k,events);

        
        
        // int j=0;
        // for(j=i+1;j<n;j++) {
        //     if(events[j][0]>events[i][1]){
        //         break;
        //     }
        // }

        int j = upperBound(i+1,n,events[i][1],events);

        int take = events[i][2]+solve(j,k-1,events);

        return dp[i][k] = Math.max(take,skip);

    }

    public int upperBound(int low, int high, int target,int[][]events){
        

        while(low<high){
            int mid=low+(high-low)/2;
            if(events[mid][0]<=target){
                low=mid+1;
            }
            else {
                high=mid;
            }
        }
        return low;
    }
}