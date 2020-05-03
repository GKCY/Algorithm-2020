package base;

public class No130 {
    int m;
    int n;
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                replace(board, i, 0);
            if (board[i][n-1] == 'O')
                replace(board, i, n-1);
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                replace(board, 0, j);
            if (board[m-1][j] == 'O')
                replace(board, m-1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'P')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    public void  replace(char[][] board, int i, int j) {
        board[i][j] = 'P';
        int[] dx = {0 , 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O')
                replace(board, x, y);
        }
    }
}
