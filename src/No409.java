import java.util.HashMap;

public class No409 {
    public int longestPalindrome(String s) {
        int res = 0;
        boolean isodd = false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch :
                s.toCharArray()) {
            if (map.containsKey(ch))
                map.put(ch, map.get(ch)+1);
            else
                map.put(ch, 1);
        }
        for (char ch : map.keySet()) {
            if (map.get(ch) % 2 == 0)
                res += map.get(ch) / 2;
            else
                isodd = true;
        }
        return isodd ? res + 1 : res;

    }
}
