package base;

import tool.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() == 0)
            return res;
        int[] need = new int[26];
        int[] exist = new int[26];
        int left = 0, right = 0;
        int size = 0, needSize = 0;
        for (int i = 0; i < p.length(); i++) {
            if (need[p.charAt(i)-'a']++ == 0)
                needSize++;
        }
//        System.out.println(needSize);
//        Utils.printArrays(need);
        while (right < s.length()) {
                char c = s.charAt(right);
                if (need[c-'a'] == 0) {
                    left = right + 1;
                    right = right + 1;
                    exist = new int[26];
                    size = 0;
                } else {
                    exist[c-'a']++;
                    if (exist[c-'a'] == need[c-'a'])
                        size++;
                    else if (exist[c-'a'] == need[c-'a'] + 1)
                        size--;
                    right++;
                }

                if (right - left == p.length()) {
                    if (size == needSize)
                        res.add(left);
                    char ch = s.charAt(left);
                    exist[ch-'a']--;
                    if (exist[ch-'a'] == need[ch-'a'])
                        size++;
                    if (exist[ch-'a'] == need[ch-'a'] - 1)
                        size--;
                    left++;
                }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "a";
        System.out.println(new No438().findAnagrams(s, p));
    }
}
