package base;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class No49  {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList<>();
        HashMap<String, ArrayList> map = new HashMap<>();
        for (String s :
                strs) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String key = String.valueOf(temp);
            if (!map.containsKey(key))
                map.put(key, new ArrayList());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}
