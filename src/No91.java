

public class No91 {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        if (s.charAt(0) == '0')
            return 0;
        else
            dp[0] = 1;

        if (s.length() > 1) {
            int num = Integer.parseInt(s.substring(0, 2));
            if (num >= 10 && num <= 26) {
                if (s.charAt(1) == '0')
                    dp[1] = 1;
                else
                    dp[1] = 2;
            } else {
                if (s.charAt(1) == '0')
                    dp[1] = 0;
                else
                    dp[1] = 1;
            }
        }
        for (int i = 2; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                if (s.charAt(i-1) != '1' && s.charAt(i-1) != '2')
                    return 0;
                else
                    dp[i] = dp[i-2];
            } else {
                int num = Integer.parseInt(s.substring(i-1, i+1));
                if (num >= 1 && num <= 9) {
                    dp[i] = dp[i-1];
                } else if (num >= 10 && num <= 26) {
                    dp[i] = dp[i-1] + dp[i-2];
                } else if (num > 26) {
                    dp[i] = dp[i-1];
                }
            }
        }
        return dp[s.length()-1];
    }

    public static void main(String[] args) {
        No91 t = new No91();
        System.out.println(t.numDecodings("227"));
    }
}
