class Solution {
    int count=0;
    int[][] direction = {
        {0,1} , {0,-1}, {1,0} ,{-1,0}
    };

    int res=0;
    
    public int uniquePathsIII(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        
        int x=0;
        int y=0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==1) {
                   x=i;
                   y=j;
                }

                else if(grid[i][j]==0){
                    count++;
                }
            }
        }
       
       path(grid, x, y, 0);
       return res;

      
    }


    public void path(int[][] grid , int x , int y, int block) {
        int m=grid.length;
        int n=grid[0].length;
        

        if(x<0 || x>=m || y<0 || y>=n || grid[x][y]==-1) {
            return ;
        }

        if(grid[x][y] == 2){
           if(block == count + 1) {
            res++;
           }
          return;
        }

        int temp=grid[x][y];
        grid[x][y]=-1;
        int ans=0;
        for(int[] dirn: direction) {
            int new_x=x+dirn[0];
            int new_y=y+dirn[1];

             path(grid,new_x,new_y,block+1);
              
        }

        grid[x][y]=temp;

        return ;
    }
}