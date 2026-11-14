class Solution {
    public int findNumbers(int[] nums) {
        int ans=0;
        for(int num : nums) {
            if(count(num)){
                ans++;
            }
        }
        return ans;
    }

    public boolean count(int n) {
        int c=0;
        while(n>0) {
            n=n/10;
            c++;
        }
        return c%2==0;
    }
}