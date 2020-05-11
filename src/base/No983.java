package base;

public class No983 {
    public int mincostTickets(int[] days, int[] costs) {
        int endDay = days[days.length-1];
        int[] dp = new int[endDay+1];
        for (int day :
                days) {
            dp[day] = -1;
        }
        for (int i = 1; i <= endDay; i++) {
            if (dp[i] == 0)
                dp[i] = dp[i-1];
            else {
                int one = dp[i-1] + costs[0];
                int seven = (i - 7 < 1 ? 0 : dp[i-7])+ costs[1];
                int thirty = (i - 30 < 1 ? 0 : dp[i-30]) + costs[2];
                dp[i] = Math.min(one, Math.min(seven, thirty));
            }
        }
        return dp[endDay];
    }
}
