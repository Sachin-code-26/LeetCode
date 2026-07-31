class Solution {
    public long countBadPairs(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]-i;
        }

        Map<Integer,Integer> map = new HashMap<>();
        map.put(nums[0],0);
        long ans=0;

        for(int j=0;j<nums.length;j++) {
            int countOfNumsJ = map.getOrDefault(nums[j], 0);
            int totalnumb4j=j;
            int badPairs=j-countOfNumsJ;

            ans+=badPairs;

           map.put(nums[j], countOfNumsJ + 1);
        }

        return ans;
    }
}