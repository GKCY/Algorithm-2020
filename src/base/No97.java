package base;

public class No97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int x = s1.length(), y = s2.length(), z = s3.length();
        if (x + y != z)
            return false;
        boolean[][] dp = new boolean[x+1][y+1];
        dp[0][0] = true;
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                if (i > 0) {
                    dp[i][j] |= (s1.charAt(i-1) == s3.charAt(i+j-1)) && dp[i-1][j];
                }

                if (j > 0) {
                    dp[i][j] |= (s2.charAt(j-1) == s3.charAt(i+j-1)) && dp[i][j-1];
                }
            }
        }
        return dp[x][y];
    }
}
