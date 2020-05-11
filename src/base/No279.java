package base;

public class No279 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int k = 1, min = Integer.MAX_VALUE;
            while (true) {
                if (i - k * k < 0) break;
                min = Math.min(min, dp[i - k * k] + 1);
                k++;
            }
            dp[i] = min;
        }
        return dp[n];
    }

}
