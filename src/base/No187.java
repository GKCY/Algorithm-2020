package base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class No187 {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String str = s.substring(i, i + 10);
            int count = map.getOrDefault(str, 0);
            if (count == 1)
                res.add(str);
            map.put(str, count + 1);
        }
        return res;
    }

    public List<String> findRepeatedDnaSequences1(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() <= 10) return res;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Character, Integer> alphabet = new HashMap<>();
        alphabet.put('A', 0);
        alphabet.put('C', 1);
        alphabet.put('G', 2);
        alphabet.put('T', 3);
        int stringHash = 0;
        for (int i = 0; i < 10; i++) {
            stringHash <<= 2;
            stringHash |= alphabet.get(s.charAt(i));
        }
        map.put(stringHash, 1);

        for (int i = 10; i < s.length(); i++) {
            stringHash = stringHash & ~(3 << 18);
            stringHash <<= 2;
            stringHash |= alphabet.get(s.charAt(i));

            int count = map.getOrDefault(stringHash, 0);
            if (count == 1)
                res.add(s.substring(i-9, i+1));
            map.put(stringHash, count+1);
        }
        return res;
    }

    public void print(int num) {
        String str = Integer.toBinaryString(num);
        int cnt = 20 - str.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            builder.append("0");
        }
        builder.append(str);
        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        No187 t = new No187();
        t.findRepeatedDnaSequences1("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }

}
