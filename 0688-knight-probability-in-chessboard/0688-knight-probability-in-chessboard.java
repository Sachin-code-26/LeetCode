class Solution {
    int[][] dirn = {
        {-2,1},{-1,2},{1,2},{2,1},
        {2,-1},{1,-2},{-1,-2},{-2,-1}
    };
    HashMap<String,Double> map = new HashMap<>();
    public double knightProbability(int n, int k, int row, int column) {
        
      return solve(n,k,row,column);  
    }

    public double solve(int n , int k, int r, int c) {
        if(r<0 || c<0 || r>=n || c>=n) {
            return 0;
        }

        if(k==0){
            return 1;
        }

        String key = r + "_" + c + "_" + k;

        if(map.containsKey(key)){
            return map.get(key);
        }
        
        double result=0;
        for(int[] dir : dirn) {
            int new_r = dir[0]+r;
            int new_c = dir[1]+c;

            result+=solve(n,k-1,new_r,new_c);
        }
        
        map.put(key,result/8);
        return result/8;
    }
}