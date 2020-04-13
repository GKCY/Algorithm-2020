import java.util.HashMap;

public class No887 {
    HashMap<Integer, Integer> mem = new HashMap<>();
    public int superEggDrop(int K, int N) {
        return dp(K, N);
    }

    public int dp(int K, int N) {
        if (N == 0 || K == 0)
            return 0;
        if (K == 1)
            return N;
        if (N == 1)
            return 1;
        int key = N * 100 + K;
        if (!mem.containsKey(key)) {
            int left = 1, right = N;
            while (left <= right) {
                int mid = (left + right) / 2;
                int broken = dp(K - 1, mid - 1);
                int notBroken = dp(K, N - mid);
                if (notBroken > broken) {
                    left = mid + 1;
                }
                else if (notBroken <= broken) {
                    right = mid - 1;
                }
            }
            int value;
            if (left == 1)
                value = Math.max(dp(K - 1, left - 1), dp(K, N - left));
            else if (right == N)
                value = Math.max(dp(K - 1, right - 1), dp(K, N - right));
            else
                value = Math.min(Math.max(dp(K - 1, left - 1), dp(K, N - left)),
                        Math.max(dp(K - 1, right - 1), dp(K, N - right)))
                        + 1;

            mem.put(key, value);
        }
        return mem.get(key);
    }

//    public int dp(int K, int N) {
//        if (N == 0)
//            return 0;
//        if (K == 1)
//            return N;
//        if (N == 1)
//            return 1;
//        int key = N * 100 + K;
//        if (!mem.containsKey(key)) {
//            int left = 1, right = N;
//            while (left + 1 < right) {
//                int mid = (left + right) / 2;
//                int broken = dp(K - 1, mid - 1);
//                int notBroken = dp(K, N - mid);
//
//                if (notBroken > broken)
//                    left = mid;
//                else if (notBroken < broken)
//                    right = mid;
//                else
//                    left = right = mid;
//                }
//            int value;
//            value = 1 + Math.min(Math.max(dp(K - 1, left - 1), dp(K, N - left)),
//                        Math.max(dp(K - 1, right - 1), dp(K, N - right)));
//            mem.put(key, value);
//        }
//        return mem.get(key);
//    }

//    public int dp(int K, int N) {
//        //可以优化为一维数组DP
//        int[][] dp = new int[K+1][N+1];
//        int m = 0;
//        while (dp[K][m] < N) {
//            m++;
//            for (int i = 1; i <= K; i++) {
//                dp[i][m] = dp[i-1][m-1] + dp[i][m-1] + 1;
//            }
//        }
//        return m;
//    }

    public static void main(String[] args) {
        No887 t = new No887();
        System.out.println(t.superEggDrop(2, 7));
        //2 6 3
        //3 14 4
        //2 7 4
    }
}
