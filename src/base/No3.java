package base;

import java.util.HashMap;

public class No3 {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j))+1);
            }
            ans = Math.max(ans, j-i+1);
            map.put(s.charAt(j), j);
        }
        return ans;
    }
}
