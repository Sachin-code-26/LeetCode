class Solution {
    public int[] shuffle(int[] nums, int n) {
       int[] arr = new int[2*n];
       int idx=0;
       for(int i=0;i<n;i++) {
        arr[idx]=nums[i];
        idx+=2;
       }

        idx=1;
       for(int i=n;i<2*n;i++) {
        arr[idx]=nums[i];
        idx+=2;
       }

       return arr;
    }
}