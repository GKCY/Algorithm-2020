import java.util.Arrays;

public class No63 {
    public int solution(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0)
            return 0;
        int n = obstacleGrid[0].length;
        if (n == 0)
            return 0;

        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    dp[j] = 0;
                else {
                    dp[j] = dp[j] + (j - 1 < 0 ? 0 : dp[j-1]);
                }
            }
        }
        return dp[n-1];
    }
}
