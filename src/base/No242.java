package base;

import java.util.Arrays;
import java.util.HashMap;

public class No242 {
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        return Arrays.equals(s1, s2);
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            counts[c - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            counts[c - 'a']--;
        }

        for (int count : counts) {
            if (count != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new No242().isAnagram("anagram","nagaram"));
    }
}
