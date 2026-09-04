class Solution {
    int n;
    int[] dp;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        n = startTime.length;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        int[][] arr = new int[n][3];
        for(int i=0;i<n;i++){
            arr[i][0]=startTime[i];
            arr[i][1]=endTime[i];
            arr[i][2]=profit[i];
        }
        Arrays.sort(arr,(a,b)->{
           return a[0]-b[0];
        });

       return solve(arr,0);
    }

    public int solve(int[][] arr , int i){
        if(i>=n) {
            return 0;
        }

        if(dp[i]!=-1){
            return dp[i];
        }
        
        int next = binarySearch(arr, i+1, arr[i][1]);

        int take = arr[i][2] + solve(arr, next);

        int skip = solve(arr, i+1);

        return dp[i]=Math.max(take,skip);
    }

    public int binarySearch(int[][] arr , int l, int currentEnd) {
        
        int r = n-1;
        int result = n+1;

        while(l<=r) {
            int mid = l+(r-l)/2;


            if(arr[mid][0]>=currentEnd){
                result = mid;
                r = mid-1;
            }
            else{
                l = mid +1;
            }
        }

        return result;
    }
}