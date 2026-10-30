class Solution {
    public int sumOfUnique(int[] nums) {
        int[] arr = new int[101];
        int n = nums.length;
        for(int i=0;i<n;i++){
            arr[nums[i]]+=1;
        }

        int sum=0;

        for(int i=0;i<n;i++) {
            if(arr[nums[i]]==1){
                sum+=nums[i];
            }
        }

        return sum;
    }
}