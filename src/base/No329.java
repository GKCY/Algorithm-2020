package base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class No329 {
    int[][] dp;
    int m;
    int n;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int[][] matrix;
    int res = 1;
    public int longestIncreasingPath1(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        if (m == 0)
            return 0;
        n = matrix[0].length;
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0)
                    dfs(i, j);
            }
        }
        return res;
    }

    public int dfs(int i, int j) {
        if (dp[i][j] != 0)
            return dp[i][j];
        dp[i][j] = 1;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[i][j] < matrix[x][y]) {
                dp[i][j] = Math.max(dp[i][j],dfs(x, y)+1);
            }
        }
        res = Math.max(res, dp[i][j]);
        return dp[i][j];

    }

    public int longestIncreasingPath2(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        ArrayList<int[]> points = new ArrayList<>(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                points.add(new int[]{i, j});
            }
        }
        points.sort(Comparator.comparingInt(a -> matrix[a[0]][a[1]]));

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(dp[i], 1);
        int res = 1;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for (int[] point : points) {
            int i = point[0];
            int j = point[1];
            for (int k = 0; k < 4; k++) {
                int x = i + dx[k];
                int y = j + dy[k];
                if (x >= 0 && x < m && y >= 0 && y < n && matrix[i][j] > matrix[x][y]) {
                    dp[i][j] = Math.max(dp[i][j], dp[x][y] + 1);
                }
            }
            res = Math.max(res, dp[i][j]);
        }
        return res;
    }
}
