package competition;

import java.util.HashMap;
import java.util.HashSet;

public class No5520 {
    int res = 0;
    HashSet<String> set = new HashSet<>();
    public int maxUniqueSplit(String s) {
        dfs(s);
        return res;
    }

    public void dfs(String str) {
        if (str.length() == 0) {
            res = Math.max(res, set.size());
            return;
        }

        for (int i = 1; i <= str.length(); i++) {
            String sub = str.substring(0, i);
            if (!set.contains(sub)) {
                set.add(sub);
                dfs(str.substring(i, str.length()));
                set.remove(sub);
            }
        }
    }

    public static void main(String[] args) {
        String str = "";
        System.out.println(new No5520().maxUniqueSplit(str));
    }
}
