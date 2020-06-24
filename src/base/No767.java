package base;

public class No767 {
    public static String reorganizeString(String S) {
        int[] count = new int[26];
        for (char ch : S.toCharArray()) {
            if (++count[ch - 'a'] > (S.length() + 1) / 2)
                return "";
        }
        char[] str = new char[S.length()];
        int even = 0, odd = 1;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                while (count[i] > 0 && odd < S.length()
                        && count[i] < S.length()/2+1) {
                    str[odd] = (char) ('a' + i);
                    odd += 2;
                    count[i]--;
                }
                while (count[i]> 0) {
                    str[even] = (char) ('a' + i);
                    even += 2;
                    count[i]--;
                }
            }
        }
        return new String(str);
    }
}
