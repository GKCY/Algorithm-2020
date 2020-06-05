package base;

public class No1035 {
    public int maxUncrossedLines(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m == 0 || n == 0)
            return 0;
        int[][] dp = new int[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (A[i] == B[0] && count == 0)
                count++;
            dp[i][0] = count;
        }
        count = 0;
        for (int i = 0; i < n; i++) {
            if (A[0] == B[i] && count == 0)
                count++;
            dp[0][i] = count;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (A[i] == B[j])
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[m-1][n-1];
    }
}
