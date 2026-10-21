class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans=0;
        for(int[] row : accounts){
            int sum=0;
            for(int i=0;i<row.length;i++) {
                sum+= row[i];
            }
           ans =Math.max(ans,sum);
        }

        return ans;
    }
}