package base;

import java.util.HashSet;

public class No1160 {
    public int countCharacters(String[] words, String chars) {
        int res = 0;
        int[] table = new int[26];
        for (char ch : chars.toCharArray()) {
            table[ch - 'a']++;
        }
        start : for (String word : words) {
           int[] record = new int[26];
            for (char ch : word.toCharArray())
                record[ch - 'a']++;
            for (int i = 0; i < 26; i++) {
                if (record[i] > table[i])
                    continue start;
            }
            res += word.length();
        }
        return res;
    }
}
