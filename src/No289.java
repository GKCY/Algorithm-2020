public class No289 {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        int[] dx = {-1, -1, -1, 0, 1, 1,  1,  0};
        int[] dy = {-1,  0,  1, 1, 1, 0, -1, -1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int alive = 0;
                for (int k = 0; k < 8; k++) {
                    int x = i, y = j;
                    x += dx[k];
                    y += dy[k];
                    if (x < m && x >= 0 && y >= 0 && y < n)
                        if (board[x][y] == 1 || board[x][y] == 3)
                            alive++;
                } // 2: 0->1      3: 1->0
                if (board[i][j] == 1 && (alive < 2 || alive > 3)) {
                    board[i][j] = 3;
                } else if (board[i][j] == 0 && alive == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2)
                    board[i][j] = 1;
                if (board[i][j] == 3)
                    board[i][j] = 0;
            }
    }

    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        No289 t = new No289();
        t.gameOfLife(board);
    }
}
