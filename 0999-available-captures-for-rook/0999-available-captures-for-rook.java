class Solution {
    public int numRookCaptures(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        int row = -1;
        int col = -1;

        // Find rook
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'R') {
                    row = i;
                    col = j;
                    break;
                }
            }
        }

        // Up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == '.') {
                continue;
            } else if (board[i][col] == 'B') {
                break;
            } else if (board[i][col] == 'p') {
                count++;
                break;
            }
        }

        // Down
        for (int i = row + 1; i < m; i++) {
            if (board[i][col] == '.') {
                continue;
            } else if (board[i][col] == 'B') {
                break;
            } else if (board[i][col] == 'p') {
                count++;
                break;
            }
        }

        // Right
        for (int i = col + 1; i < n; i++) {
            if (board[row][i] == '.') {
                continue;
            } else if (board[row][i] == 'B') {
                break;
            } else if (board[row][i] == 'p') {
                count++;
                break;
            }
        }

        // Left
        for (int i = col - 1; i >= 0; i--) {
            if (board[row][i] == '.') {
                continue;
            } else if (board[row][i] == 'B') {
                break;
            } else if (board[row][i] == 'p') {
                count++;
                break;
            }
        }

        return count;
    }
}