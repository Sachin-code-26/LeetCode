class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int score = 0;
        for(int ele : nums){
            score+=ele;
        }

        int p1 = solve(0,n-1,nums);

        return p1>=score-p1;
    }

    public int solve(int i, int j , int[] nums) {
        if(i>j){
            return 0;
        }

        int take_i = nums[i] + Math.min(solve(i+2,j,nums),solve(i+1,j-1,nums));
        int take_j = nums[j] + Math.min(solve(i+1,j-1,nums),solve(i,j-2,nums));

        return Math.max(take_i,take_j);
    }
}