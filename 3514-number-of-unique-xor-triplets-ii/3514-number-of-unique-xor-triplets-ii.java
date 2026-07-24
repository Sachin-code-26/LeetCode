class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        boolean[] arr = new boolean[2048];
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                 arr[nums[i]^nums[j]]=true;
            }
        }
       
     boolean[] ans = new boolean[2048];
       for(int i=0;i<2048;i++) {
          if(arr[i]) {
            for(int num : nums) {
                ans[i ^ num] = true;
            }
          }
       }

       int count = 0;

        for(boolean b : ans) {
            if(b == true){
                count++;
            }
        }

        return count;
    }
}