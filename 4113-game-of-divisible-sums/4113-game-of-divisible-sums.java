class Solution {
    public long maxDifference(int[] nums) {
        int n = nums.length;

        long[] dp = new long[n+2];

        for(int i=n-1;i>=0;i--) {

            long sum1 = nums[i];

            long option1;

            if(sum1%3==0) {
                option1 = sum1 - dp[i+1];
            } else {
                option1 = sum1 + dp[i+1];
            }

            long option2 = Long.MIN_VALUE;

            if(i+1<n) {

                long sum2 = (long) nums[i] + nums[i+1];

                if(sum2 % 3 ==0) {
                    option2 = sum2-dp[i+2];
                } else {
                    option2 = sum2 + dp[i+2];
                }
            }

            dp[i] = Math.max(option1,option2);
        }

        return dp[0];
    }
}