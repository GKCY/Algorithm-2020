package base;

import java.util.ArrayList;
import java.util.HashMap;

public class No395 {
    public int longestSubstring(String s, int k) {
        if (s.length() == 0 || s.length() < k)
            return 0;
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map[ch-'a']++;
        }
        ArrayList<Integer> split = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map[ch-'a'] < k)
                split.add(i);
        }
        if (split.size() == 0)
            return s.length();
        split.add(s.length());
        int start = 0;
        int ans = 0;
        for (int end : split) {
            ans = Math.max(ans, longestSubstring(s.substring(start, end), k));
            start = end + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "ababbc";
        int k = 2;
        System.out.println(new No395().longestSubstring(s, k));
    }
}
