package base;

import java.util.ArrayList;
import java.util.List;

public class No763 {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            last[ch-'a'] = i;
        }

        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (end == i) {
                res.add(end - start + 1);
                start = i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(new No763().partitionLabels(s));
    }
}
