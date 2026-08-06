class Solution {

    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for(int i=0;i<n;i++){
          Arrays.fill(board[i],'.');
        }

        solve(0,board,n);

        return result;
    }

    public void solve(int row, char[][] board, int n) {

        if(row==n){
            result.add(construct(board));
            return;
        }

        for(int col=0;col<n;col++) {
            if(isSafe(row,col,board,n)) {
                board[row][col]='Q';
                solve(row+1,board,n);
                board[row][col]='.';
            }
        }
    }


    public boolean isSafe(int row, int col, char[][] board, int n ) {

        //vertically

        for(int i=row;i>=0;i--) {
            if(board[i][col]=='Q'){
                return false;
            }
        }

        //left diagonal

        for(int i=row,j=col; i>=0 && j>=0; i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        //right diagonal

        for(int i=row,j=col;i>=0 && j<n ;i--,j++){
            if(board[i][j]=='Q') {
                return false;
            }
        }
      
      return true;
    }

    public List<String> construct(char[][] board) {
        List<String> temp = new ArrayList<>();

        for(char[] row : board) {
            temp.add(new String(row));
        }

        return temp;
    }
}