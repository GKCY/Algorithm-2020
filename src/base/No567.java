package base;

import java.util.Arrays;
import java.util.HashMap;

public class No567 {
    public boolean checkInclusion1(String s1, String s2) {
        int[] need = new int[26];
        int[] exist = new int[26];
        int needCount = 0, count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (need[s1.charAt(i) - 'a']++ == 0)
                needCount++;
        }

        int l = 0, r = 0;
        while (r < s2.length()) {
            char ch = s2.charAt(r++);
            if (need[ch-'a'] == 0) {
                l = r;
                Arrays.fill(exist, 0);
                count = 0;
            } else {
                if (need[ch-'a'] == exist[ch-'a'] + 1)
                    count++;
                else if (need[ch-'a'] == exist[ch-'a'])
                    count--;
                exist[ch-'a']++;
            }

            if (r - l == s1.length()) {
                if (count == needCount)
                    return true;
                else {
                    ch = s2.charAt(l);
                    if (need[ch-'a'] == exist[ch-'a'])
                        count--;
                    else if (need[ch-'a'] == exist[ch-'a']-1)
                        count++;
                    exist[ch-'a']--;
                    l++;
                }
            }
        }
        return false;
    }

    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int l = 0, r = 0;
        while (r < s2.length()) {
            char ch = s2.charAt(r++);
            map.put(ch, map.getOrDefault(ch, 0) - 1);
            while (l < r && map.get(ch) < 0) {
                char c = s2.charAt(l++);
                map.put(c, map.get(c) + 1);
            }
            if (r - l == s1.length())
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bbbca";
        System.out.println(new No567().checkInclusion(s1, s2));
    }
}
