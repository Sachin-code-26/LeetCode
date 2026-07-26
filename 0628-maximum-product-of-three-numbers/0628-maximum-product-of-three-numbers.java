class Solution {
    public int maximumProduct(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int secmax=Integer.MIN_VALUE;
        int thirdmax=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
           if(nums[i]>=max){
                thirdmax = secmax;
                secmax = max;
                max = nums[i];
           }

           else if(nums[i]>=secmax){
            thirdmax=secmax;
            secmax=nums[i];
           }

           else if(nums[i]>thirdmax) {
            thirdmax=nums[i];
           }
        }
        

        // 2 min
        int min=Integer.MAX_VALUE;
        int secmin=Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
           if(nums[i]<=min){
            secmin=min;
            min=nums[i];
           }

           else if(nums[i]<secmin){
            secmin=nums[i];
           }

           
        }
        
        int positive= max*secmax*thirdmax;
        int neg=min*secmin*max;
        return Math.max(positive,neg);
    }
}