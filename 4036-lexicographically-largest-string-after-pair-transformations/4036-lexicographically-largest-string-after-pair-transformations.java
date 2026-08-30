class Solution {
    public String[] largestString(int[] nums) {
        
        String[] ans = new String[nums.length];

        for(int i=0;i<nums.length;i++) {
            int x= nums[i];

            StringBuilder s = new StringBuilder();

            for(int j=25; j>=0;j--) {
                int value = (int) Math.pow(2,j);

                while(x>=value) {
                    s.append((char) ('a' + j));
                    x-=value;
                }
            }

            ans[i]=s.toString();
        }

        return ans;
    }
}