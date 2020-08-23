package base;

import tool.Utils;

public class No529 {
    int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
    int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};
    int m, n;
    int[][] numsOfBomb;
    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;
        numsOfBomb = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                numsOfBomb[i][j] = count(board, i, j);
            }
        }

//        Utils.printMatrix(numsOfBomb);
        int x = click[0], y = click[1];

        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }

        if (board[x][y] == 'E' && numsOfBomb[x][y] > 0) {
            board[x][y] = (char) ('0' + numsOfBomb[x][y]);
            return board;
        }

        if (board[x][y] == 'E' && numsOfBomb[x][y] == 0) {
            dfs(board, x, y);
        }

        return board;
    }

    public void dfs(char[][] board, int ox, int oy) {
        if (numsOfBomb[ox][oy] == 0) {
            board[ox][oy] = 'B';
            for (int i = 0; i < 8; i++) {
                int x = ox + dx[i];
                int y = oy + dy[i];
                if (legal(x, y) && (board[x][y] == 'E'))
                    dfs(board, x, y);
            }
        } else
            board[ox][oy] = (char) ('0' + numsOfBomb[ox][oy]);

//        Utils.printMatrix(board);
//        System.out.println("\n");
    }

    public int count(char[][] board, int ox, int oy) {
        int res = 0;
        for (int i = 0; i < 8; i++) {
            int x = ox + dx[i];
            int y = oy + dy[i];
            if (legal(x, y) && (board[x][y] == 'M' || board[x][y] == 'X'))
                res++;
        }
        return res;
    }

    public boolean legal(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        char[][] board = {{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        int[] click = {3, 0};
        No529 t = new No529();
        t.updateBoard(board, click);
    }
}
