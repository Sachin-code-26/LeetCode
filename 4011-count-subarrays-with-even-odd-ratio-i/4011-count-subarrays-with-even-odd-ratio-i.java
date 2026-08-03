class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int n=nums.length;
        int[] even=new int[n];
        int[] odd=new int[n];

        even[0] = (nums[0] % 2 == 0) ? 1 : 0;
        odd[0] = (nums[0] % 2 == 0) ? 0 : 1;

        for(int i=1;i<n;i++){
            even[i]=even[i-1];
            odd[i]=odd[i-1];
            if(nums[i]%2==0){
                even[i]++;
            }else{
                odd[i]++;
            }
        }

        int ans=0;

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int evenCount, oddCount;

                if(i==0){
                    evenCount=even[j];
                    oddCount=odd[j];
                }
                else{
                    evenCount=even[j]-even[i-1];
                    oddCount=odd[j]-odd[i-1];
                }

                if(oddCount>0 && 1L * evenCount * b <= 1L * oddCount * a){
                    ans++;
                }
            }
        }

        return ans;
    }
}