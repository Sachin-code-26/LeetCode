class Solution {
    int m;
    int n;
    int[][] dp;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        m = nums1.length;
        n = nums2.length;
        dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                Arrays.fill(dp[i],-1);
            }
        }
        return solve(0,0, nums1 ,nums2);
    }

    public int solve(int i , int j, int[] nums1 , int[] nums2){
        if(i>=m){
            return 0;
        }

        if(j>=n) {
            return 0;
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
       
        if(nums1[i]==nums2[j]) {
            return dp[i][j] = 1 + solve(i+1,j+1,nums1,nums2);
        }
        else{
            return dp[i][j] = Math.max(solve(i,j+1, nums1,nums2) , solve(i+1, j , nums1 ,nums2));
        }
    }
}