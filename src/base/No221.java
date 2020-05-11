package base;

import tool.Tools;

public class No221 {
    public int maximalSquare(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int max = 0;
        int[] dp = new int[n];
        int pre = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int temp = dp[j];
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0)
                        dp[j] = 1;
                    else
                        dp[j] = Math.min(dp[j-1], Math.min(dp[j], pre)) + 1;
                } else {
                    dp[j] = 0;
                }
                max = Math.max(max, dp[j]);
                pre = temp;
            }
        }

        return max * max;
    }

    public static void main(String[] args) {
        No221 t = new No221();
        int[][] matrix = {{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,0},{1,1,1,1,1,1,1,0},{1,1,1,1,1,0,0,0},{0,1,1,1,1,0,0,0}};
        t.maximalSquare(matrix);
    }
}
