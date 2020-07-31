package base;

import java.util.HashMap;

public class No318 {
    public int maxProduct1(String[] words) {
        int[] bits = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char ch = words[i].charAt(j);
                bits[i] |= 1 << (ch - 'a');
            }
        }

        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if ((bits[i] & bits[j]) == 0)
                    res = Math.max(res, words[i].length() * words[j].length());
            }
        }
        return res;
    }

    public int maxProduct2(String[] words) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            int bits = 0;
            for (int j = 0; j < words[i].length(); j++) {
                bits |= 1 << (words[i].charAt(j) - 'a');
            }
            map.put(bits, Math.max(map.getOrDefault(bits, 0), words[i].length()));
        }

        int res = 0;
        for(int i : map.keySet()) {
            for (int j : map.keySet())
                if ((i & j) == 0)
                    res = Math.max(res, map.get(i) * map.get(j));
        }
        return res;
    }
}
