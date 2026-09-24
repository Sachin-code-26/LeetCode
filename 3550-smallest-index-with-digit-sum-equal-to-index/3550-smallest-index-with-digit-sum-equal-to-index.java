class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        int ans=-1;
        for(int i=0;i<n;i++) {
            if(sum(nums[i])==i){
                ans=i;
                break;
            }
        }

        return ans;
    }
    
    public int sum(int n) {
        int s=0;
        while(n>0) {
            int r=n%10;
            s+=r;
            n=n/10;
        }

        return s;
    }
}