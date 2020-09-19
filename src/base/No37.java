package base;

import tool.Utils;

import java.util.Arrays;

public class No37 {

    boolean[][] row = new boolean[9][10];
    boolean[][] col = new boolean[9][10];
    boolean[][] zone = new boolean[9][10];
    char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    row[i][num] = true;
                    col[j][num] = true;
                    zone[(i / 3) * 3 + (j / 3)][num] = true;
                }
            }
        }

        int[] res = findNext(0, -1);
        boolean exist = res[0] == 1 ? true : false;
        int x = res[1], y = res[2];
        if (exist) {
            backtrack(x, y);
        }
    }

    public boolean backtrack(int i, int j) {
        int[] res = findNext(i, j);
        boolean exist = res[0] == 1 ? true : false;
        int x = res[1], y = res[2];

        for (int k = 1; k <= 9; k++) {
            if (!row[i][k] && !col[j][k] && !zone[(i / 3) * 3 + (j / 3)][k]) {
                row[i][k] = true;
                col[j][k] = true;
                zone[(i / 3) * 3 + (j / 3)][k] = true;
                board[i][j] = (char) ('0' + k);
                if (exist) {
                    if (backtrack(x, y))
                        return true;
                } else {
                    System.out.println(String.format("%d %d", i, j));
                    Utils.printMatrix(board);
                    return true;
                }
                board[i][j] = '.';
                row[i][k] = false;
                col[j][k] = false;
                zone[(i / 3) * 3 + (j / 3)][k] = false;
            }
        }
        return false;
    }

    public int[] findNext(int i, int j) {
        int[] res = new int[3];
        int a = i, b = j + 1;
        while (a < 9) {
            while (b < 9) {
                if (board[a][b] == '.') {
                    res[0] = 1;
                    res[1] = a;
                    res[2] = b;
                    return res;
                }
                b++;
            }
            a++;
            b = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++)
            Arrays.fill(board[i], '.');
        No37 t = new No37();
        t.solveSudoku(board);
        Utils.printArrays(t.findNext(0, 8));
    }

}