package base;

import java.util.Arrays;

public class No542 {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int[] arr :
                dp) {
            Arrays.fill(arr, 10000);
        }
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0)
                    dp[i][j] = 0;
                else {
                    for (int k = 0; k < 2; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            dp[i][j] = Math.min(dp[i][j], dp[x][y] + 1);
                        }
                    }
                }
            }
        }

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (dp[i][j] == 0)
                    continue;
                for (int k = 2; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        dp[i][j] = Math.min(dp[i][j], dp[x][y] + 1);
                    }
                }
            }
        }

        return dp;
    }
}
