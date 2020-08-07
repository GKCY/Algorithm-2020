package base;

public class No714 {
    public int maxProfit1(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        //0不持有 1持有
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return Math.max(dp[prices.length-1][0], dp[prices.length-1][1]);
    }

    public int maxProfit2(int[] prices, int fee) {
        int hold = -prices[0];
        int unHold = 0;
        for (int i = 1; i < prices.length; i++) {
            unHold = Math.max(unHold, hold + prices[i] - fee);
            hold = Math.max(hold, unHold - prices[i]);
        }
        return Math.max(hold, unHold);
    }
}
