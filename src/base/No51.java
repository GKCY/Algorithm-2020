package base;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class No51 {
    public List<String> show() {
        int n = board.length;
        List<String> res = new ArrayList<>(board.length);
        for (int i = 0; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0)
                    builder.append('.');
                else
                    builder.append('Q');
            }
            res.add(builder.toString());
        }
        return res;
    }

    HashSet<Integer> col = new HashSet<>();
    HashSet<Integer> set1 = new HashSet<>();
    HashSet<Integer> set2 = new HashSet<>();
    int[][] board;
    public List<List<String>> solveNQueens(int n) {
        board = new int[n][n];
        List<List<String>> res = new ArrayList<>();
        backtrack(res, 0);
        return res;
    }

    public void backtrack(List<List<String>> res, int i) {
        if (i == board.length)
            res.add(show());
        for (int j = 0; j < board.length; j++) {
            if (legal(i, j)) {
                col.add(j);
                set1.add(i+j);
                set2.add(i-j);
                board[i][j] = 1;
                backtrack(res, i+1);
                col.remove(j);
                set1.remove(i+j);
                set2.remove(i-j);
                board[i][j] = 0;
            }
        }
    }

    public boolean legal(int x, int y) {
        return !col.contains(y) && !set1.contains(x+y) && !set2.contains(x-y);
    }


    public static void main(String[] args) {
        No51 t = new No51();
        List<List<String>> lists = t.solveNQueens(4);
        System.out.println(lists);
    }

}
