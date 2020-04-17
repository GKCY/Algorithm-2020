package base;

public class No62 {
    public int solution1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                int up = i - 1 < 0 ? 0 : dp[i-1][j];
                int left = j - 1 < 0 ? 0 : dp[i][j-1];
                dp[i][j] = up + left;
            }
        }
        return dp[m-1][n-1];
    }

    public int solution2(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[j] = 1;
                    continue;
                }
                dp[j] = dp[j] + (j - 1 < 0 ? 0 : dp[j-1]);
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        No62 t = new No62();
        System.out.println(
               t.solution2(3,2)
        );
    }
}
