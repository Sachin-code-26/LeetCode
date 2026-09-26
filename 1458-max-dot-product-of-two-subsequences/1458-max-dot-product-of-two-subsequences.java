class Solution {
    int n;
    int m;
    int[][] dp;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        m = nums1.length;
        n = nums2.length;
        dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++) {
            for(int j=0;j<=n;j++) {
                Arrays.fill(dp[i],-1);
            }
        }
        return solve(0,0, nums1,nums2);
    }

    public int solve(int i , int j , int[] nums1, int[]nums2) {
        if(i==m || j==n) {
            return -1000000000;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int val = nums1[i]*nums2[j];

        int take_i_j = val + solve(i+1,j+1,nums1,nums2);
        int take_i = solve(i,j+1,nums1,nums2);
        int take_j = solve(i+1,j,nums1,nums2);

        return dp[i][j] = Math.max(val,Math.max(take_i_j,Math.max(take_i,take_j)));
     }
}