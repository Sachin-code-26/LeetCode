class Solution {
    int N;
    int Goal;
    int K;
    int M = (int)1e9+7;
    long dp[][];
    public int numMusicPlaylists(int n, int goal, int k) {
        N = n;
        Goal = goal;
        K =k;
        dp = new long[goal+1][n+1];

        for(int i=0;i<=goal;i++){
            for(int j=0;j<=n;j++){
                Arrays.fill(dp[i],-1);
            }
        }

        return (int)solve(0,0);
    }

    public long solve(int countSong, int UniqueSong) {
        if(countSong==Goal) {
            if(UniqueSong==N) {
                return 1;
            }
            return 0;
        }

         if(dp[countSong][UniqueSong]!=-1){
                return dp[countSong][UniqueSong];
            }

        long result=0;
        if(N-UniqueSong>0){
             result+=(N-UniqueSong)*solve(countSong+1, UniqueSong+1);
        }
        if(UniqueSong-K>0){
            result+= (UniqueSong-K)*solve(countSong+1,UniqueSong);
        }
        

        result = result%M;
       

       return dp[countSong][UniqueSong] = result;
    }
}