package base;

public class No718 {
    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = A[i] == B[j] ? 1 : 0;
                else if (A[i] == B[j])
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = 0;
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;

    }

    public int findLength2(int[] A, int[] B) {
        int[] dp = new int[B.length];
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = B.length - 1; j >= 0; j--) {
                if (i == 0 || j == 0)
                    dp[j] = A[i] == B[j] ? 1 : 0;
                else if (A[i] == B[j])
                    dp[j] = dp[j-1] + 1;
                else
                    dp[j] = 0;
                res = Math.max(res, dp[j]);
            }
        }
        return res;

    }
}
