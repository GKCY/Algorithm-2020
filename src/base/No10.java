package base;

import tool.Utils;

public class No10 {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int j = 2; j < p.length() + 1; j++) {
            dp[0][j] = p.charAt(j-1) == '*' && dp[0][j-2];
        }
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                int m = i - 1, n = j - 1;
                if (s.charAt(m) == p.charAt(n) || p.charAt(n) == '.')
                    dp[i][j] = dp[i-1][j-1];
                else if (p.charAt(n) == '*') {
                    if (n - 1 >= 0 && p.charAt(n-1) == s.charAt(m) || p.charAt(n-1) == '.')
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-2] || dp[i][j-2];
                    else if (n - 1 >= 0 && p.charAt(n-1) != s.charAt(m))
                        dp[i][j] = dp[i][j-2];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        String s = "baabbbaccbccacacc";
        String p = "c*..b*a*a.*a..*c";
        System.out.println(new No10().isMatch(s, p));
    }
}
