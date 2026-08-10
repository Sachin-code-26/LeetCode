class Solution {
    int n;
    int count=0;
    int[][] t;
    public int combinationSum4(int[] nums, int target) {
       n=nums.length;

       t = new int[target+1][n];

       for(int i=0;i<=target;i++){
        Arrays.fill(t[i],-1);
       }

       return solve(0,target,nums);
    }

    public int solve(int idx, int target, int[] nums) {
        if(target==0){
            return 1;
        }

        if(idx>=n || target<0) {
            return 0;
        }

        if(t[target][idx]!=-1){
            return t[target][idx];
        }

       int take= solve(0,target-nums[idx],nums);
       int reject = solve(idx+1,target,nums);

       return t[target][idx] = take+reject;
    }
}