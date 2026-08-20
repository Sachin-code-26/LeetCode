class Solution {
    int m;
    int n;
    int[][] dp;
    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;
        n = dungeon[0].length;
        int left = 1;
        int right = (int)(4*1e7);
        int minHealth = (int)(4*1e7);

        while(left<=right) {
            int mid = left+(right-left)/2;
            dp = new int[m][n];
            if(canSurvive(0,0, mid , dungeon)) {
                minHealth = mid;
                right = mid-1;
            }
            else{
                left= mid+1;
            }
        }

        return minHealth;

    }


    public boolean canSurvive(int i , int j , int health , int[][] dungeon) {
        if(i>=m || j>=n) {
            return false;
        }

        health+=dungeon[i][j];
        
        if(health<=0){
            return false;
        }

        if(dp[i][j]>=health){
            return false;
        }

        dp[i][j] = health;


        if(i==m-1 && j==n-1) {
            return true;
        }
       
        
        return canSurvive(i+1,j,health,dungeon) || canSurvive(i,j+1,health,dungeon);
    }
}