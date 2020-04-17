package base;

import java.util.HashMap;

public class No3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < n; j++){
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(s.charAt(j)+1, i);
            }
            ans = Math.max(ans, j-i+1);
            map.put(s.charAt(j), j);
        }
        return ans;
    }
}
