package competition;

import tool.Utils;

import java.util.HashSet;

public class No5469 {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length())
            return false;
        if (s.length() == 0)
            return true;

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i))
                continue;
            int dist = cal(s.charAt(i), t.charAt(i));
            count[dist]++;
        }

        Utils.printArrays(count);

        for (int i = 1; i <= 25; i++) {
            if (count[i] > 0 && !have(k, i, count[i]))
                return false;
        }
        return true;
    }

    public boolean have(int k, int idx, int num) {
        if (idx > k)
            return false;
        k = k - idx;
        k = k / 26;
        return k >= num - 1;
    }

    public int cal(char c1, char c2) {
        int dist = (int)(c2 - c1);
        if (dist > 0)
            return dist;
        else
            return 26 + dist;
    }

    public static void main(String[] args) {
        No5469 T = new No5469();

        String s = "jicfxaa";
        String t = "ocxltbp";
        int k = 15;
        System.out.println(T.canConvertString(s, t, k));
//        System.out.println(T.have(27, 1,2));
    }
}
