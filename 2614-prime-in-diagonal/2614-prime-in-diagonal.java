class Solution {
    int n;
    public int diagonalPrime(int[][] nums) {
        
        n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++) { 

            for(int j=0;j<n;j++) {
                if(i==j || i+j==n-1 ){
                    if(isPrime(nums[i][j])) {
                        ans=Math.max(ans,nums[i][j]);
                    }
                }
            }
        }
        return ans;
    }

    public boolean isPrime(int num) {
        
        int count = 0;
        if(num<2){
            return false;
        }
        for(int i=2; i*i<=num;i++) {
            if(num % i ==0) {
              count++;
            }
        }

        return count == 0;
    }
}