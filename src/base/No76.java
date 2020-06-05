package base;

import java.util.HashMap;

public class No76 {
    //滑动窗口
    HashMap<Character, Integer> need = new HashMap();
    HashMap<Character, Integer> exist = new HashMap<>();
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";
        for (char ch : t.toCharArray())
            need.put(ch, need.getOrDefault(ch, 0) + 1);

        int i, j;
        i = j = 0;
        int valid = 0;
        int len = s.length() + 1, start = 0;
        while (j < s.length()) {
            char ch;
            int cnt;
            ch = s.charAt(j);
            if (need.containsKey(ch)) {
                cnt = exist.getOrDefault(ch, 0);
                if (cnt == need.get(ch) - 1)
                    valid++;
                exist.put(ch, cnt + 1);
            }
            j++;

            while (valid == need.size()) {
                if (j - i < len) {
                    len = j - i;
                    start = i;
                }
                ch = s.charAt(i);
                if (need.containsKey(ch)) {
                    cnt = exist.get(ch);
                    if (cnt == need.get(ch))
                        valid--;
                    exist.put(ch, cnt-1);
                }
                i++;

            }
        }

        return len == s.length() + 1 ? "" : s.substring(start, start + len);
    }


    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
//        String s = "a";
//        String t = "a";
        System.out.println(new No76().minWindow(s, t));
    }
}
