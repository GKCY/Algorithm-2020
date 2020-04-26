package base;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class No139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for (String str : wordDict) {
            set.add(str);
        }

        int length = s.length();
        boolean[] dp = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (set.contains(s.substring(0, i+1))) {
                dp[i] = true;
                continue;
            }
            for (int j = 1; j <= i; j++) {
                if (dp[j-1] == true && set.contains(s.substring(j, i+1))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length-1];
    }

    public static void main(String[] args) {
        String s = "ab";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("a");
        wordDict.add("b");
        System.out.println(No139.wordBreak(s, wordDict));
    }
}
