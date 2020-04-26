package base;

import java.util.List;

public class No120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size()-2; i >= 0; i--) {
            List<Integer> cur = triangle.get(i);
            List<Integer> down = triangle.get(i+1);
            System.out.println(cur);
            for (int j = 0; j < cur.size(); j++) {
                int left = down.get(j);
                int right = j + 1 == down.size() ? 0 : down.get(j + 1);
                int val = cur.remove(j);
                cur.add(j, Math.min(left, right) + val);
            }
        }
        return triangle.get(0).get(0);
    }
}
