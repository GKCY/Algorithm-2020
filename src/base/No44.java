package base;

import tool.Utils;

public class No44 {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0)
            return s.length() == 0;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i-1) == '*' && dp[0][i-1])
                dp[0][i] = true;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j-1) == '?' || s.charAt(i-1) == p.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        String s = "";
        String p = "";
        System.out.println(new No44().isMatch(s, p));
    }
}
