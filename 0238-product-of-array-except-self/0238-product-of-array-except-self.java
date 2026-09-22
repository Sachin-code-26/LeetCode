class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int zeros=0;
        int product_without_zero = 1;

        for(int ele : nums){
            if(ele==0){
                zeros++;
            }
            else{
                product_without_zero*=ele;
            }
        }
        int[] result = new int[nums.length];
        for(int i=0;i<n;i++) {
            if(nums[i]!=0) {
                if(zeros>0){
                    result[i]=0;
                }
                else{
                    result[i] = product_without_zero/nums[i];
                }
            } else{
                if(zeros>1){
                    result[i]=0;
                } else{
                    result[i] = product_without_zero;
                }
            }
        }

        return result;
    }
}