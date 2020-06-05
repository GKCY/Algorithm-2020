package base;

public class No837 {
    //方法一: 超时
    public double new21Game1(int N, int K, int W) {
        if (K == 0)
            return 1.0;
        double[] dp = new double[K + W];
        for (int i = K; i < K + W && i <= N; i++)
            dp[i] = 1.0;
        for (int i = K - 1; i >= 0; i--) {
            for (int j = 1; j <= W; j++) {
                dp[i] += dp[i + j] / W;
            }
        }
        return dp[0];
    }

    //方法二: 超时
    public double new21Game2(int N, int K, int W) {
        if (K == 0)
            return 1.0;
        double[] dp = new double[N+1];
        double[] sum = new double[N+1];
        dp[0] = 1.0;
        sum[0] = 1.0;
        for (int i = 1; i <= N; i++) {
            int l = Math.max(0, i - W);
            int r = Math.min(i - 1, K - 1);
            for (int j = l; j <= r; j++) {
                dp[i] += dp[j] / W;
            }
            sum[i] = sum[i - 1] + dp[i];
        }
        return sum[N] - sum[K-1];
    }

    //方法三：滑动窗口保存概率和，减去了方法一、二的第二次循环累计计算
    public double new21Game3(int N, int K, int W) {
        if (K == 0)
            return 1.0;
        double[] dp = new double[K + W + 1];
        double window = 0.0;
        for (int i = K; i < K + W && i <= N; i++)
            dp[i] = 1.0;
        for (int i = K + 1; i <= K + W;i++)
            window += dp[i];
        for (int i = K - 1; i >= 0; i--) {
            //窗口向前滚动
            window = window - dp[i + W + 1] + dp[i+1];
            dp[i] = window / W;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(new No837().new21Game3(5017 ,4725, 1863));
    }
}
