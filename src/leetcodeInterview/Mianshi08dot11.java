package leetcodeInterview;

public class Mianshi08dot11 {
    public int waysToChange(int n) {
        int[] coins = {1, 5, 10, 25};
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= coins[i])
                    dp[j] = (dp[j] + dp[j-coins[i]]) % 1000000007;
            }
        }
        return dp[n];
    }
}
